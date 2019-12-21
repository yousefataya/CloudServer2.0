
package org.mitre.openid.connect.repository;

import org.mitre.openid.connect.model.Address;

public interface AddressRepository {

	/**
	 * Returns the Address for the given id
	 *
	 * @param id
	 *            id the id of the Address
	 * @return a valid Address if it exists, null otherwise
	 */
	public Address getById(Long id);

}
