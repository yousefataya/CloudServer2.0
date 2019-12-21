
package org.mitre.openid.connect.repository;

import org.mitre.openid.connect.model.ApprovedSite;

import java.util.Collection;

public interface ApprovedSiteRepository {

	/**
	 * Returns the ApprovedSite for the given id
	 *
	 * @param id
	 *            id the id of the ApprovedSite
	 * @return a valid ApprovedSite if it exists, null otherwise
	 */
	public ApprovedSite getById(Long id);

	/**
	 * Return a collection of all ApprovedSites managed by this repository
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
	 * Removes the given ApprovedSite from the repository
	 *
	 * @param aggregator
	 *            the ApprovedSite object to remove
	 */
	public void remove(ApprovedSite approvedSite);

	/**
	 * Persists an ApprovedSite
	 *
	 * @param aggregator
	 *            valid ApprovedSite instance
	 * @return the persisted entity
	 */
	public ApprovedSite save(ApprovedSite approvedSite);

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

}
