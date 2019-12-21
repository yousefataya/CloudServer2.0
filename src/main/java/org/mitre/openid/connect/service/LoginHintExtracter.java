

package org.mitre.openid.connect.service;

public interface LoginHintExtracter {

	/**
	 * @param loginHint
	 * @return
	 */
	public String extractHint(String loginHint);

}
