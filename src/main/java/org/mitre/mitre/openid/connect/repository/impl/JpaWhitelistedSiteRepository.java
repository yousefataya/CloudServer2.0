package org.mitre.mitre.openid.connect.repository.impl;

import org.mitre.openid.connect.model.WhitelistedSite;
import org.mitre.openid.connect.repository.WhitelistedSiteRepository;
import org.mitre.util.jpa.JpaUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

import static org.mitre.util.jpa.JpaUtil.saveOrUpdate;

@Repository
public class JpaWhitelistedSiteRepository implements WhitelistedSiteRepository {

	@PersistenceContext(unitName="EXPERTS-MYSQL")
	private EntityManager manager;

	@Override
	@Transactional(value="defaultTransactionManager")
	public Collection<WhitelistedSite> getAll() {
		TypedQuery<WhitelistedSite> query = manager.createNamedQuery(WhitelistedSite.QUERY_ALL, WhitelistedSite.class);
		return query.getResultList();
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public WhitelistedSite getById(Long id) {
		return manager.find(WhitelistedSite.class, id);
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public void remove(WhitelistedSite whitelistedSite) {
		WhitelistedSite found = manager.find(WhitelistedSite.class, whitelistedSite.getId());

		if (found != null) {
			manager.remove(found);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public WhitelistedSite save(WhitelistedSite whiteListedSite) {
		return saveOrUpdate(whiteListedSite.getId(), manager, whiteListedSite);
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public WhitelistedSite update(WhitelistedSite oldWhitelistedSite, WhitelistedSite whitelistedSite) {
		// sanity check
		whitelistedSite.setId(oldWhitelistedSite.getId());

		return saveOrUpdate(oldWhitelistedSite.getId(), manager, whitelistedSite);
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public WhitelistedSite getByClientId(String clientId) {
		TypedQuery<WhitelistedSite> query = manager.createNamedQuery(WhitelistedSite.QUERY_BY_CLIENT_ID, WhitelistedSite.class);
		query.setParameter(WhitelistedSite.PARAM_CLIENT_ID, clientId);
		return JpaUtil.getSingleResult(query.getResultList());
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public Collection<WhitelistedSite> getByCreator(String creatorId) {
		TypedQuery<WhitelistedSite> query = manager.createNamedQuery(WhitelistedSite.QUERY_BY_CREATOR, WhitelistedSite.class);
		query.setParameter(WhitelistedSite.PARAM_USER_ID, creatorId);

		return query.getResultList();
	}
}
