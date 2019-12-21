

package org.mitre.uma.service;

import org.mitre.oauth2.model.RegisteredClient;
import org.mitre.uma.model.SavedRegisteredClient;

import java.util.Collection;

public interface SavedRegisteredClientService {

	/**
	 * Get a list of all the registered clients that we know about.
	 *
	 * @return
	 */
	Collection<SavedRegisteredClient> getAll();

	/**
	 * @param issuer
	 * @param client
	 */
	void save(String issuer, RegisteredClient client);


}
