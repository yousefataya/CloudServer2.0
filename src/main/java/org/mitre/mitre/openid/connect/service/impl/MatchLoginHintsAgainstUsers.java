package org.mitre.mitre.openid.connect.service.impl;

import com.google.common.base.Strings;
import org.mitre.openid.connect.model.UserInfo;
import org.mitre.openid.connect.service.LoginHintExtracter;
import org.mitre.openid.connect.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;

public class MatchLoginHintsAgainstUsers implements LoginHintExtracter {

	@Autowired
	private UserInfoService userInfoService;

	/* (non-Javadoc)
	 * @see org.mitre.openid.connect.service.LoginHintTester#useHint(java.lang.String)
	 */
	@Override
	public String extractHint(String loginHint) {
		if (Strings.isNullOrEmpty(loginHint)) {
			return null;
		} else {
			UserInfo user = userInfoService.getByEmailAddress(loginHint);
			if (user == null) {
				user = userInfoService.getByUsername(loginHint);
				if (user == null) {
					return null;
				} else {
					return user.getPreferredUsername();
				}
			} else {
				return user.getPreferredUsername();
			}
		}
	}

}
