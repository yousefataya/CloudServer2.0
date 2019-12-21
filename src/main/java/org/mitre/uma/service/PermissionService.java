

package org.mitre.uma.service;

import org.mitre.uma.model.PermissionTicket;
import org.mitre.uma.model.ResourceSet;
import org.springframework.security.oauth2.common.exceptions.InsufficientScopeException;

import java.util.Set;

public interface PermissionService {

	/**
	 * @param resourceSet the resource set to create the permission on
	 * @param scopes the set of scopes that this permission is for
	 * @return the created (and stored) permission object, with ticket
	 * @throws InsufficientScopeException if the scopes in scopes don't match those in resourceSet.getScopes
	 */
	public PermissionTicket createTicket(ResourceSet resourceSet, Set<String> scopes);

	/**
	 *
	 * Read the permission associated with the given ticket.
	 *
	 * @param the ticket value to search on
	 * @return the permission object, or null if none is found
	 */
	public PermissionTicket getByTicket(String ticket);

	/**
	 * Save the updated permission ticket to the database. Does not create a new ticket.
	 *
	 * @param ticket
	 * @return
	 */
	public PermissionTicket updateTicket(PermissionTicket ticket);

}
