
package org.mitre.mitre.openid.connect.repository.impl;

import org.mitre.openid.connect.model.Address;
import org.mitre.openid.connect.repository.AddressRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaAddressRepository implements AddressRepository {

	@PersistenceContext(unitName="EXPERTS-MYSQL")
	private EntityManager manager;

	@Override
	@Transactional(value="defaultTransactionManager")
	public Address getById(Long id) {
		return manager.find(Address.class, id);
	}

}
