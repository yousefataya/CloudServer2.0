

package org.mitre.mitre.openid.connect.service.impl;

import com.google.common.base.Strings;
import org.mitre.openid.connect.service.LoginHintExtracter;

public class RemoveLoginHintsWithHTTP implements LoginHintExtracter {

	/* (non-Javadoc)
	 * @see org.mitre.openid.connect.service.LoginHintTester#useHint(java.lang.String)
	 */
	@Override
	public String extractHint(String loginHint) {
		if (Strings.isNullOrEmpty(loginHint)) {
			return null;
		} else {
			if (loginHint.startsWith("http")) {
				return null;
			} else {
				return loginHint;
			}
		}
	}

}
