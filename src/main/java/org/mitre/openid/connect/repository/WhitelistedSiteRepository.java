
package org.mitre.openid.connect.repository;

import org.mitre.openid.connect.model.WhitelistedSite;

import java.util.Collection;

public interface WhitelistedSiteRepository {

	/**
	 * Return a collection of all WhitelistedSite managed by this repository
	 *
	 * @return the WhitelistedSite collection, or null
	 */
	public Collection<WhitelistedSite> getAll();

	/**
	 * Returns the WhitelistedSite for the given id
	 *
	 * @param id
	 *            id the id of the WhitelistedSite
	 * @return a valid WhitelistedSite if it exists, null otherwise
	 */
	public WhitelistedSite getById(Long id);

	/**
	 * Find a WhitelistedSite by its associated ClientDetails reference
	 *
	 * @param client	the Relying Party
	 * @return			the corresponding WhitelistedSite if one exists for the RP, or null
	 */
	public WhitelistedSite getByClientId(String clientId);

	/**
	 * Return a collection of the WhitelistedSites created by a given user
	 *
	 * @param creator	the id of the admin who may have created some WhitelistedSites
	 * @return			the collection of corresponding WhitelistedSites, if any, or null
	 */
	public Collection<WhitelistedSite> getByCreator(String creatorId);

	/**
	 * Removes the given IdToken from the repository
	 *
	 * @param whitelistedSite
	 *            the WhitelistedSite object to remove
	 */
	public void remove(WhitelistedSite whitelistedSite);

	/**
	 * Persists a WhitelistedSite
	 *
	 * @param whitelistedSite
	 * @return
	 */
	public WhitelistedSite save(WhitelistedSite whiteListedSite);

	/**
	 * Persist changes to a whitelistedSite. The ID of oldWhitelistedSite is retained.
	 * @param oldWhitelistedSite
	 * @param whitelistedSite
	 * @return
	 */
	public WhitelistedSite update(WhitelistedSite oldWhitelistedSite, WhitelistedSite whitelistedSite);

}
