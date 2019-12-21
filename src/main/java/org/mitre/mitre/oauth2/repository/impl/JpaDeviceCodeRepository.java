
package org.mitre.mitre.oauth2.repository.impl;

import org.mitre.oauth2.model.DeviceCode;
import org.mitre.oauth2.repository.impl.DeviceCodeRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.Date;

import static org.mitre.util.jpa.JpaUtil.getSingleResult;
import static org.mitre.util.jpa.JpaUtil.saveOrUpdate;


@Repository("jpaDeviceCodeRepository")
public class JpaDeviceCodeRepository implements DeviceCodeRepository {

	@PersistenceContext(unitName="EXPERTS-MYSQL")
	private EntityManager em;

	
	@Override
	@Transactional(value="defaultTransactionManager")
	public DeviceCode getById(Long id) {
		return em.find(DeviceCode.class, id);
	}

	
	@Override
	@Transactional(value="defaultTransactionManager")
	public DeviceCode getByUserCode(String value) {
		TypedQuery<DeviceCode> query = em.createNamedQuery(DeviceCode.QUERY_BY_USER_CODE, DeviceCode.class);
		query.setParameter(DeviceCode.PARAM_USER_CODE, value);
		return getSingleResult(query.getResultList());
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public DeviceCode getByDeviceCode(String value) {
		TypedQuery<DeviceCode> query = em.createNamedQuery(DeviceCode.QUERY_BY_DEVICE_CODE, DeviceCode.class);
		query.setParameter(DeviceCode.PARAM_DEVICE_CODE, value);
		return getSingleResult(query.getResultList());
	}

	
	@Override
	@Transactional(value="defaultTransactionManager")
	public void remove(DeviceCode scope) {
		DeviceCode found = getById(scope.getId());

		if (found != null) {
			em.remove(found);
		}

	}

	
	@Override
	@Transactional(value="defaultTransactionManager")
	public DeviceCode save(DeviceCode scope) {
		return saveOrUpdate(scope.getId(), em, scope);
	}

	
	@Override
	@Transactional(value="defaultTransactionManager")
	public Collection<DeviceCode> getExpiredCodes() {
		TypedQuery<DeviceCode> query = em.createNamedQuery(DeviceCode.QUERY_EXPIRED_BY_DATE, DeviceCode.class);
		query.setParameter(DeviceCode.PARAM_DATE, new Date());
		return query.getResultList();
	}

}
