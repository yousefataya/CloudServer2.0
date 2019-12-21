

package org.mitre.openid.connect.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class MITREidDataServiceMaps {

	private Map<Long, Long> accessTokenOldToNewIdMap = new HashMap<Long, Long>();
	private Map<Long, Long> accessTokenToAuthHolderRefs = new HashMap<Long, Long>();
	private Map<Long, String> accessTokenToClientRefs = new HashMap<Long, String>();
	private Map<Long, Long> accessTokenToRefreshTokenRefs = new HashMap<Long, Long>();
	private Map<Long, Long> authHolderOldToNewIdMap = new HashMap<Long, Long>();
	private Map<Long, Long> grantOldToNewIdMap = new HashMap<>();
	private Map<Long, Set<Long>> grantToAccessTokensRefs = new HashMap<>();
	private Map<Long, Long> refreshTokenOldToNewIdMap = new HashMap<Long, Long>();
	private Map<Long, Long> refreshTokenToAuthHolderRefs = new HashMap<Long, Long>();
	private Map<Long, String> refreshTokenToClientRefs = new HashMap<Long, String>();
	private Map<Long, Long> whitelistedSiteOldToNewIdMap = new HashMap<Long, Long>();
	/**
	 * @return the accessTokenOldToNewIdMap
	 */
	public Map<Long, Long> getAccessTokenOldToNewIdMap() {
		return accessTokenOldToNewIdMap;
	}
	/**
	 * @return the accessTokenToAuthHolderRefs
	 */
	public Map<Long, Long> getAccessTokenToAuthHolderRefs() {
		return accessTokenToAuthHolderRefs;
	}
	/**
	 * @return the accessTokenToClientRefs
	 */
	public Map<Long, String> getAccessTokenToClientRefs() {
		return accessTokenToClientRefs;
	}
	/**
	 * @return the accessTokenToRefreshTokenRefs
	 */
	public Map<Long, Long> getAccessTokenToRefreshTokenRefs() {
		return accessTokenToRefreshTokenRefs;
	}
	/**
	 * @return the authHolderOldToNewIdMap
	 */
	public Map<Long, Long> getAuthHolderOldToNewIdMap() {
		return authHolderOldToNewIdMap;
	}
	/**
	 * @return the grantOldToNewIdMap
	 */
	public Map<Long, Long> getGrantOldToNewIdMap() {
		return grantOldToNewIdMap;
	}
	/**
	 * @return the grantToAccessTokensRefs
	 */
	public Map<Long, Set<Long>> getGrantToAccessTokensRefs() {
		return grantToAccessTokensRefs;
	}
	/**
	 * @return the refreshTokenOldToNewIdMap
	 */
	public Map<Long, Long> getRefreshTokenOldToNewIdMap() {
		return refreshTokenOldToNewIdMap;
	}
	/**
	 * @return the refreshTokenToAuthHolderRefs
	 */
	public Map<Long, Long> getRefreshTokenToAuthHolderRefs() {
		return refreshTokenToAuthHolderRefs;
	}
	/**
	 * @return the refreshTokenToClientRefs
	 */
	public Map<Long, String> getRefreshTokenToClientRefs() {
		return refreshTokenToClientRefs;
	}
	/**
	 * @return the whitelistedSiteOldToNewIdMap
	 */
	public Map<Long, Long> getWhitelistedSiteOldToNewIdMap() {
		return whitelistedSiteOldToNewIdMap;
	}

	public void clearAll() {
		refreshTokenToClientRefs.clear();
		refreshTokenToAuthHolderRefs.clear();
		accessTokenToClientRefs.clear();
		accessTokenToAuthHolderRefs.clear();
		accessTokenToRefreshTokenRefs.clear();
		refreshTokenOldToNewIdMap.clear();
		accessTokenOldToNewIdMap.clear();
		grantOldToNewIdMap.clear();
	}

}
