
package org.mitre.oauth2.service;

import org.mitre.oauth2.model.ClientDetailsEntity;
import org.mitre.oauth2.model.OAuth2AccessTokenEntity;
import org.mitre.oauth2.model.OAuth2RefreshTokenEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

import java.util.List;
import java.util.Set;

public interface OAuth2TokenEntityService extends AuthorizationServerTokenServices, ResourceServerTokenServices {

	@Override
	public OAuth2AccessTokenEntity readAccessToken(String accessTokenValue);

	public OAuth2RefreshTokenEntity getRefreshToken(String refreshTokenValue);

	public void revokeRefreshToken(OAuth2RefreshTokenEntity refreshToken);

	public void revokeAccessToken(OAuth2AccessTokenEntity accessToken);

	public List<OAuth2AccessTokenEntity> getAccessTokensForClient(ClientDetailsEntity client);

	public List<OAuth2RefreshTokenEntity> getRefreshTokensForClient(ClientDetailsEntity client);

	public void clearExpiredTokens();

	public OAuth2AccessTokenEntity saveAccessToken(OAuth2AccessTokenEntity accessToken);

	public OAuth2RefreshTokenEntity saveRefreshToken(OAuth2RefreshTokenEntity refreshToken);

	@Override
	public OAuth2AccessTokenEntity getAccessToken(OAuth2Authentication authentication);

	public OAuth2AccessTokenEntity getAccessTokenById(Long id);

	public OAuth2RefreshTokenEntity getRefreshTokenById(Long id);

	public Set<OAuth2AccessTokenEntity> getAllAccessTokensForUser(String name);

	public Set<OAuth2RefreshTokenEntity> getAllRefreshTokensForUser(String name);

	public OAuth2AccessTokenEntity getRegistrationAccessTokenForClient(ClientDetailsEntity client);
}
