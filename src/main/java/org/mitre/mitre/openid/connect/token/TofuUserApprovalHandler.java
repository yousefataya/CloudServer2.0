
package org.mitre.mitre.openid.connect.token;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import org.mitre.mitre.openid.connect.web.AuthenticationTimeStamper;
import org.mitre.oauth2.service.SystemScopeService;
import org.mitre.openid.connect.model.ApprovedSite;
import org.mitre.openid.connect.model.WhitelistedSite;
import org.mitre.openid.connect.service.ApprovedSiteService;
import org.mitre.openid.connect.service.WhitelistedSiteService;
/*import org.mitre.openid.connect.web.AuthenticationTimeStamper;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.*;

import static org.mitre.mitre.openid.connect.request.ConnectRequestParameters.*;

@Component("tofuUserApprovalHandler")
public class TofuUserApprovalHandler implements UserApprovalHandler {

	@Autowired
	private ApprovedSiteService approvedSiteService;

	@Autowired
	private WhitelistedSiteService whitelistedSiteService;

	@Autowired
	private ClientDetailsService clientDetailsService;

	@Autowired
	private SystemScopeService systemScopes;

	/**
	 * Check if the user has already stored a positive approval decision for this site; or if the
	 * site is whitelisted, approve it automatically.
	 *
	 * Otherwise, return false so that the user will see the approval page and can make their own decision.
	 *
	 * @param authorizationRequest	the incoming authorization request
	 * @param userAuthentication	the Principal representing the currently-logged-in user
	 *
	 * @return 						true if the site is approved, false otherwise
	 */
	@Override
	public boolean isApproved(AuthorizationRequest authorizationRequest, Authentication userAuthentication) {

		// if this request is already approved, pass that info through
		// (this flag may be set by updateBeforeApproval, which can also do funny things with scopes, etc)
		if (authorizationRequest.isApproved()) {
			return true;
		} else {
			// if not, check to see if the user has approved it
			// TODO: make parameter name configurable?
			return Boolean.parseBoolean(authorizationRequest.getApprovalParameters().get("user_oauth_approval"));
		}

	}

	/**
	 * Check if the user has already stored a positive approval decision for this site; or if the
	 * site is whitelisted, approve it automatically.
	 *
	 * Otherwise the user will be directed to the approval page and can make their own decision.
	 *
	 * @param authorizationRequest	the incoming authorization request
	 * @param userAuthentication	the Principal representing the currently-logged-in user
	 *
	 * @return 						the updated AuthorizationRequest
	 */
	@Override
	public AuthorizationRequest checkForPreApproval(AuthorizationRequest authorizationRequest, Authentication userAuthentication) {

		//First, check database to see if the user identified by the userAuthentication has stored an approval decision

		String userId = userAuthentication.getName();
		String clientId = authorizationRequest.getClientId();

		//lookup ApprovedSites by userId and clientId
		boolean alreadyApproved = false;

		// find out if we're supposed to force a prompt on the user or not
		String prompt = (String) authorizationRequest.getExtensions().get(PROMPT);
		List<String> prompts = Splitter.on(PROMPT_SEPARATOR).splitToList(Strings.nullToEmpty(prompt));
		if (!prompts.contains(PROMPT_CONSENT)) {
			// if the prompt parameter is set to "consent" then we can't use approved sites or whitelisted sites
			// otherwise, we need to check them below

			Collection<ApprovedSite> aps = approvedSiteService.getByClientIdAndUserId(clientId, userId);
			for (ApprovedSite ap : aps) {

				if (!ap.isExpired()) {

					// if we find one that fits...
					if (systemScopes.scopesMatch(ap.getAllowedScopes(), authorizationRequest.getScope())) {

						//We have a match; update the access date on the AP entry and return true.
						ap.setAccessDate(new Date());
						approvedSiteService.save(ap);

						String apId = ap.getId().toString();
						authorizationRequest.getExtensions().put(APPROVED_SITE, apId);
						authorizationRequest.setApproved(true);
						alreadyApproved = true;

						setAuthTime(authorizationRequest);
					}
				}
			}

			if (!alreadyApproved) {
				WhitelistedSite ws = whitelistedSiteService.getByClientId(clientId);
				if (ws != null && systemScopes.scopesMatch(ws.getAllowedScopes(), authorizationRequest.getScope())) {
					authorizationRequest.setApproved(true);

					setAuthTime(authorizationRequest);
				}
			}
		}

		return authorizationRequest;

	}


	@Override
	public AuthorizationRequest updateAfterApproval(AuthorizationRequest authorizationRequest, Authentication userAuthentication) {

		String userId = userAuthentication.getName();
		String clientId = authorizationRequest.getClientId();
		ClientDetails client = clientDetailsService.loadClientByClientId(clientId);

		// This must be re-parsed here because SECOAUTH forces us to call things in a strange order
		if (Boolean.parseBoolean(authorizationRequest.getApprovalParameters().get("user_oauth_approval"))) {

			authorizationRequest.setApproved(true);

			// process scopes from user input
			Set<String> allowedScopes = Sets.newHashSet();
			Map<String,String> approvalParams = authorizationRequest.getApprovalParameters();

			Set<String> keys = approvalParams.keySet();

			for (String key : keys) {
				if (key.startsWith("scope_")) {
					//This is a scope parameter from the approval page. The value sent back should
					//be the scope string. Check to make sure it is contained in the client's
					//registered allowed scopes.

					String scope = approvalParams.get(key);
					Set<String> approveSet = Sets.newHashSet(scope);

					//Make sure this scope is allowed for the given client
					if (systemScopes.scopesMatch(client.getScope(), approveSet)) {

						allowedScopes.add(scope);
					}

				}
			}

			// inject the user-allowed scopes into the auth request
			authorizationRequest.setScope(allowedScopes);

			//Only store an ApprovedSite if the user has checked "remember this decision":
			String remember = authorizationRequest.getApprovalParameters().get("remember");
			if (!Strings.isNullOrEmpty(remember) && !remember.equals("none")) {

				Date timeout = null;
				if (remember.equals("one-hour")) {
					// set the timeout to one hour from now
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.HOUR, 1);
					timeout = cal.getTime();
				}

				ApprovedSite newSite = approvedSiteService.createApprovedSite(clientId, userId, timeout, allowedScopes);
				String newSiteId = newSite.getId().toString();
				authorizationRequest.getExtensions().put(APPROVED_SITE, newSiteId);
			}

			setAuthTime(authorizationRequest);


		}

		return authorizationRequest;
	}

	/**
	 * Get the auth time out of the current session and add it to the
	 * auth request in the extensions map.
	 *
	 * @param authorizationRequest
	 */
	private void setAuthTime(AuthorizationRequest authorizationRequest) {
		// Get the session auth time, if we have it, and store it in the request
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		if (attr != null) {
			HttpSession session = attr.getRequest().getSession();
			if (session != null) {
				Date authTime = (Date) session.getAttribute(AuthenticationTimeStamper.AUTH_TIMESTAMP);
				if (authTime != null) {
					String authTimeString = Long.toString(authTime.getTime());
					authorizationRequest.getExtensions().put(AuthenticationTimeStamper.AUTH_TIMESTAMP, authTimeString);
				}
			}
		}
	}

	@Override
	public Map<String, Object> getUserApprovalRequest(AuthorizationRequest authorizationRequest,
                                                      Authentication userAuthentication) {
		Map<String, Object> model = new HashMap<>();
		// In case of a redirect we might want the request parameters to be included
		model.putAll(authorizationRequest.getRequestParameters());
		return model;
	}

}
