
package org.mitre.openid.connect.service;

import org.mitre.openid.connect.model.UserInfo;

public interface UserInfoService {

	/**
	 * Get the UserInfo for the given username (usually maps to the
	 * preferredUsername field).
	 * @param username
	 * @return
	 */
	public UserInfo getByUsername(String username);

	/**
	 * Get the UserInfo for the given username (usually maps to the
	 * preferredUsername field) and clientId. This allows pairwise
	 * client identifiers where appropriate.
	 * @param username
	 * @param clientId
	 * @return
	 */
	public UserInfo getByUsernameAndClientId(String username, String clientId);

	/**
	 * Get the user registered at this server with the given email address.
	 *
	 * @param email
	 * @return
	 */
	public UserInfo getByEmailAddress(String email);

}
