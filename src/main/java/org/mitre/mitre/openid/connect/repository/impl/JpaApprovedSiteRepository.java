
package org.mitre.mitre.openid.connect.repository.impl;

import org.mitre.openid.connect.model.ApprovedSite;
import org.mitre.openid.connect.repository.ApprovedSiteRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

import static org.mitre.util.jpa.JpaUtil.saveOrUpdate;

@Repository
public class JpaApprovedSiteRepository implements ApprovedSiteRepository {

	@PersistenceContext(unitName="EXPERTS-MYSQL")
	private EntityManager manager;

	@Override
	@Transactional(value="defaultTransactionManager")
	public Collection<ApprovedSite> getAll() {
		TypedQuery<ApprovedSite> query = manager.createNamedQuery(ApprovedSite.QUERY_ALL, ApprovedSite.class);
		return query.getResultList();
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public ApprovedSite getById(Long id) {
		return manager.find(ApprovedSite.class, id);
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public void remove(ApprovedSite approvedSite) {
		ApprovedSite found = manager.find(ApprovedSite.class, approvedSite.getId());

		if (found != null) {
			manager.remove(found);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public ApprovedSite save(ApprovedSite approvedSite) {
		return saveOrUpdate(approvedSite.getId(), manager, approvedSite);
	}

	@Override
	public Collection<ApprovedSite> getByClientIdAndUserId(String clientId, String userId) {

		TypedQuery<ApprovedSite> query = manager.createNamedQuery(ApprovedSite.QUERY_BY_CLIENT_ID_AND_USER_ID, ApprovedSite.class);
		query.setParameter(ApprovedSite.PARAM_USER_ID, userId);
		query.setParameter(ApprovedSite.PARAM_CLIENT_ID, clientId);

		return query.getResultList();
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public Collection<ApprovedSite> getByUserId(String userId) {
		TypedQuery<ApprovedSite> query = manager.createNamedQuery(ApprovedSite.QUERY_BY_USER_ID, ApprovedSite.class);
		query.setParameter(ApprovedSite.PARAM_USER_ID, userId);

		return query.getResultList();

	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public Collection<ApprovedSite> getByClientId(String clientId) {
		TypedQuery<ApprovedSite> query = manager.createNamedQuery(ApprovedSite.QUERY_BY_CLIENT_ID, ApprovedSite.class);
		query.setParameter(ApprovedSite.PARAM_CLIENT_ID, clientId);

		return query.getResultList();
	}
}
