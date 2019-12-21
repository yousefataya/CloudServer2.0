

package org.mitre.uma.service;

import org.mitre.oauth2.model.OAuth2AccessTokenEntity;
import org.mitre.uma.model.PermissionTicket;
import org.mitre.uma.model.Policy;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

public interface UmaTokenService {

	/**
	 * Create the RPT from the given authentication and ticket.
	 *
	 */
	public OAuth2AccessTokenEntity createRequestingPartyToken(OAuth2Authentication o2auth, PermissionTicket ticket, Policy policy);

}
