
package org.mitre.oauth2.service;

import org.mitre.oauth2.model.OAuth2AccessTokenEntity;
import org.mitre.oauth2.model.OAuth2RefreshTokenEntity;
import org.mitre.openid.connect.model.UserInfo;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Set;

public interface IntrospectionResultAssembler {

	public String TOKEN_TYPE = "token_type";
	public String CLIENT_ID = "client_id";
	public String USER_ID = "user_id";
	public String SUB = "sub";
	public String EXP = "exp";
	public String EXPIRES_AT = "expires_at";
	public String SCOPE_SEPARATOR = " ";
	public String SCOPE = "scope";
	public String ACTIVE = "active";
	public DateFormatter dateFormat = new DateFormatter(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"));

	/**
	 * Assemble a token introspection result from the given access token and user info.
	 *
	 * @param accessToken the access token
	 * @param userInfo the user info
	 * @param authScopes the scopes the client is authorized for
	 * @return the token introspection result
	 */
	Map<String, Object> assembleFrom(OAuth2AccessTokenEntity accessToken, UserInfo userInfo, Set<String> authScopes);

	/**
	 * Assemble a token introspection result from the given refresh token and user info.
	 *
	 * @param refreshToken the refresh token
	 * @param userInfo the user info
	 * @param authScopes the scopes the client is authorized for
	 * @return the token introspection result
	 */
	Map<String, Object> assembleFrom(OAuth2RefreshTokenEntity refreshToken, UserInfo userInfo, Set<String> authScopes);

}
