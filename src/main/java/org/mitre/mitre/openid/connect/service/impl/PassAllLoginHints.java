

package org.mitre.mitre.openid.connect.service.impl;

import org.mitre.openid.connect.service.LoginHintExtracter;


public class PassAllLoginHints implements LoginHintExtracter {
	@Override
	public String extractHint(String loginHint) {
		return loginHint;
	}

}
