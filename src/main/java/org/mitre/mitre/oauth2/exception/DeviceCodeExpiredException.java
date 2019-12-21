package org.mitre.mitre.oauth2.exception;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;


public class DeviceCodeExpiredException extends OAuth2Exception {


	public DeviceCodeExpiredException(String msg) {
		super(msg);
	}


	private static final long serialVersionUID = -7078098692596870940L;


	@Override
	public String getOAuth2ErrorCode() {
		return "expired_token";
	}

}
