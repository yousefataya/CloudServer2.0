
package org.mitre.openid.connect.service;

import org.mitre.oauth2.model.OAuth2AccessTokenEntity;
import org.mitre.openid.connect.model.ApprovedSite;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;


public interface ApprovedSiteService {


	public ApprovedSite createApprovedSite(String clientId, String userId, Date timeoutDate, Set<String> allowedScopes);

	/**
	 * Return a collection of all ApprovedSites
	 *
	 * @return the ApprovedSite collection, or null
	 */
	public Collection<ApprovedSite> getAll();

	/**
	 * Return a collection of ApprovedSite managed by this repository matching the
	 * provided client ID and user ID
	 *
	 * @param clientId
	 * @param userId
	 * @return
	 */
	public Collection<ApprovedSite> getByClientIdAndUserId(String clientId, String userId);

	/**
	 * Save an ApprovedSite
	 *
	 * @param approvedSite
	 *            the ApprovedSite to be saved
	 */
	public ApprovedSite save(ApprovedSite approvedSite);

	/**
	 * Get ApprovedSite for id
	 *
	 * @param id
	 *            id for ApprovedSite
	 * @return ApprovedSite for id, or null
	 */
	public ApprovedSite getById(Long id);

	/**
	 * Remove the ApprovedSite
	 *
	 * @param approvedSite
	 *            the ApprovedSite to remove
	 */
	public void remove(ApprovedSite approvedSite);

	/**
	 * Get all sites approved by this user
	 * @param userId
	 * @return
	 */
	public Collection<ApprovedSite> getByUserId(String userId);

	/**
	 * Get all sites associated with this client
	 * @param clientId
	 * @return
	 */
	public Collection<ApprovedSite> getByClientId(String clientId);

	/**
	 * Clear out any approved sites for a given client.
	 * @param client
	 */
	public void clearApprovedSitesForClient(ClientDetails client);

	/**
	 * Remove all expired approved sites fromt he data store.
	 * @return
	 */
	public void clearExpiredSites();

	/**
	 * Return all approved access tokens for the site.
	 * @return
	 */
	public List<OAuth2AccessTokenEntity> getApprovedAccessTokens(ApprovedSite approvedSite);

}
