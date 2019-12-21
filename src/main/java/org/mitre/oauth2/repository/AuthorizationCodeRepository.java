
package org.mitre.oauth2.repository;

import org.mitre.data.PageCriteria;
import org.mitre.oauth2.model.AuthorizationCodeEntity;

import java.util.Collection;

public interface AuthorizationCodeRepository {

	/**
	 * Save an AuthorizationCodeEntity to the repository
	 *
	 * @param authorizationCode the AuthorizationCodeEntity to save
	 * @return					the saved AuthorizationCodeEntity
	 */
	public AuthorizationCodeEntity save(AuthorizationCodeEntity authorizationCode);

	/**
	 * Get an authorization code from the repository by value.
	 *
	 * @param code						the authorization code value
	 * @return							the authentication associated with the code
	 */
	public AuthorizationCodeEntity getByCode(String code);

	/**
	 * Remove an authorization code from the repository
	 *
	 * @param authorizationCodeEntity
	 */
	public void remove(AuthorizationCodeEntity authorizationCodeEntity);

	/**
	 * @return A collection of all expired codes.
	 */
	public Collection<AuthorizationCodeEntity> getExpiredCodes();

	/**
	 * @return A collection of all expired codes, limited by the given
	 * PageCriteria.
	 */
	public Collection<AuthorizationCodeEntity> getExpiredCodes(PageCriteria pageCriteria);

}
