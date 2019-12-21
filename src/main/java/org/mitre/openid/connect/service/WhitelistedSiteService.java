
package org.mitre.openid.connect.service;

import org.mitre.openid.connect.model.WhitelistedSite;

import java.util.Collection;

public interface WhitelistedSiteService {

	/**
	 * Return a collection of all WhitelistedSite managed by this service
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
	 * Removes the given WhitelistedSite from the repository
	 *
	 * @param address
	 *            the WhitelistedSite object to remove
	 */
	public void remove(WhitelistedSite whitelistedSite);

	/**
	 * Persists a new WhitelistedSite
	 *
	 * @param whitelistedSite
	 *            the WhitelistedSite to be saved
	 * @return
	 */
	public WhitelistedSite saveNew(WhitelistedSite whitelistedSite);

	/**
	 * Updates an existing whitelisted site
	 */
	public WhitelistedSite update(WhitelistedSite oldWhitelistedSite, WhitelistedSite whitelistedSite);

}
