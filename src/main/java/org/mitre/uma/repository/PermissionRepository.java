

package org.mitre.uma.repository;

import org.mitre.uma.model.Permission;
import org.mitre.uma.model.PermissionTicket;
import org.mitre.uma.model.ResourceSet;

import java.util.Collection;

public interface PermissionRepository {

	/**
	 *
	 * Save a permission ticket.
	 *
	 * @param p
	 * @return
	 */
	public PermissionTicket save(PermissionTicket p);

	/**
	 * Get the permission indicated by its ticket value.
	 *
	 * @param ticket
	 * @return
	 */
	public PermissionTicket getByTicket(String ticket);

	/**
	 * Get all the tickets in the system (used by the import/export API)
	 *
	 * @return
	 */
	public Collection<PermissionTicket> getAll();

	/**
	 * Save a permission object with no associated ticket (used by the import/export API)
	 *
	 * @param p
	 * @return
	 */
	public Permission saveRawPermission(Permission p);

	/**
	 * Get a permission object by its ID (used by the import/export API)
	 *
	 * @param permissionId
	 * @return
	 */
	public Permission getById(Long permissionId);

	/**
	 * Get all permission tickets issued against a resource set (called when RS is deleted)
	 *
	 * @param rs
	 * @return
	 */
	public Collection<PermissionTicket> getPermissionTicketsForResourceSet(ResourceSet rs);

	/**
	 * Remove the specified ticket.
	 *
	 * @param ticket
	 */
	public void remove(PermissionTicket ticket);

}
