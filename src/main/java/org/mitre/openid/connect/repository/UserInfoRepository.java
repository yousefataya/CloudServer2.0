
package org.mitre.openid.connect.repository;

import org.mitre.openid.connect.model.UserInfo;

public interface UserInfoRepository {

	/**
	 * Get a UserInfo object by its preferred_username field
	 * @param username
	 * @return
	 */
	public UserInfo getByUsername(String username);

	/**
	 *
	 * Get the UserInfo object by its email field
	 *
	 * @param email
	 * @return
	 */
	public UserInfo getByEmailAddress(String email);

}
