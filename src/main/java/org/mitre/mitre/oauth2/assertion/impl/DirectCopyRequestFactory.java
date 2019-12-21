package org.mitre.mitre.oauth2.assertion.impl;

import com.google.common.collect.Sets;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
/*import org.mitre.oauth2.assertion.AssertionOAuth2RequestFactory;*/
import lombok.NoArgsConstructor;
import org.mitre.mitre.oauth2.assertion.AssertionOAuth2RequestFactory;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Set;

@Service("assertionFactory")
@Component
@NoArgsConstructor
public class DirectCopyRequestFactory implements AssertionOAuth2RequestFactory {

	@Override
	public OAuth2Request createOAuth2Request(ClientDetails client, TokenRequest tokenRequest, JWT assertion) {

		try {
			JWTClaimsSet claims = assertion.getJWTClaimsSet();
			Set<String> scope = OAuth2Utils.parseParameterList(claims.getStringClaim("scope"));

			Set<String> resources = Sets.newHashSet(claims.getAudience());

			return new OAuth2Request(tokenRequest.getRequestParameters(), client.getClientId(), client.getAuthorities(), true, scope, resources, null, null, null);
		} catch (ParseException e) {
			return null;
		}

	}

}
