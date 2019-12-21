
package org.mitre.mitre.oauth2.assertion;

import com.nimbusds.jwt.JWT;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.TokenRequest;


public interface AssertionOAuth2RequestFactory {

	/**
	 * @param client
	 * @param tokenRequest
	 * @param assertion
	 * @return
	 */
	OAuth2Request createOAuth2Request(ClientDetails client, TokenRequest tokenRequest, JWT assertion);

}
