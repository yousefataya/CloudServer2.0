package org.mitre.mitre.oauth2.web;

import com.google.common.collect.ImmutableSet;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.exceptions.InsufficientScopeException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

public abstract class AuthenticationUtilities {

	/**
	 * Makes sure the authentication contains the given scope, throws an exception otherwise
	 * @param auth the authentication object to check
	 * @param scope the scope to look for
	 * @throws InsufficientScopeException if the authentication does not contain that scope
	 */
	public static void ensureOAuthScope(Authentication auth, String scope) {
		// if auth is OAuth, make sure we've got the right scope
		if (auth instanceof OAuth2Authentication) {
			OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) auth;
			if (oAuth2Authentication.getOAuth2Request().getScope() == null
					|| !oAuth2Authentication.getOAuth2Request().getScope().contains(scope)) {
				throw new InsufficientScopeException("Insufficient scope", ImmutableSet.of(scope));
			}
		}
	}

	/**
	 * Check to see if the given auth object has ROLE_ADMIN assigned to it or not
	 * @param auth
	 * @return
	 */
	public static boolean isAdmin(Authentication auth) {
		for (GrantedAuthority grantedAuthority : auth.getAuthorities()) {
			if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
				return true;
			}
		}
		return false;
	}


	public static boolean hasRole(Authentication auth, String role) {
		for (GrantedAuthority grantedAuthority : auth.getAuthorities()) {
			if (grantedAuthority.getAuthority().equals(role)) {
				return true;
			}
		}
		return false;

	}

}
