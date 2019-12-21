
package org.mitre.mitre.oauth2.repository.impl;

import org.mitre.data.DefaultPageCriteria;
import org.mitre.data.PageCriteria;
import org.mitre.oauth2.model.AuthenticationHolderEntity;
import org.mitre.oauth2.repository.AuthenticationHolderRepository;
import org.mitre.util.jpa.JpaUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(value="defaultTransactionManager")
public class JpaAuthenticationHolderRepository implements AuthenticationHolderRepository {

	private static final int MAXEXPIREDRESULTS = 1000;

	@PersistenceContext(unitName="EXPERTS-MYSQL")
	private EntityManager manager;

	@Override
	public List<AuthenticationHolderEntity> getAll() {
		TypedQuery<AuthenticationHolderEntity> query = manager.createNamedQuery(AuthenticationHolderEntity.QUERY_ALL, AuthenticationHolderEntity.class);
		return query.getResultList();
	}

	@Override
	public AuthenticationHolderEntity getById(Long id) {
		return manager.find(AuthenticationHolderEntity.class, id);
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public void remove(AuthenticationHolderEntity a) {
		AuthenticationHolderEntity found = getById(a.getId());
		if (found != null) {
			manager.remove(found);
		} else {
			throw new IllegalArgumentException("AuthenticationHolderEntity not found: " + a);
		}
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public AuthenticationHolderEntity save(AuthenticationHolderEntity a) {
		return JpaUtil.saveOrUpdate(a.getId(), manager, a);
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public List<AuthenticationHolderEntity> getOrphanedAuthenticationHolders() {
		DefaultPageCriteria pageCriteria = new DefaultPageCriteria(0,MAXEXPIREDRESULTS);
		return getOrphanedAuthenticationHolders(pageCriteria);
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public List<AuthenticationHolderEntity> getOrphanedAuthenticationHolders(PageCriteria pageCriteria) {
		TypedQuery<AuthenticationHolderEntity> query = manager.createNamedQuery(AuthenticationHolderEntity.QUERY_GET_UNUSED, AuthenticationHolderEntity.class);
		return JpaUtil.getResultPage(query, pageCriteria);
	}

}
