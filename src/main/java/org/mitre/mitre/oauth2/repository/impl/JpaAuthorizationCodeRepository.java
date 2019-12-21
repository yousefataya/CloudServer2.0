
package org.mitre.mitre.oauth2.repository.impl;

import org.mitre.data.PageCriteria;
import org.mitre.oauth2.model.AuthorizationCodeEntity;
import org.mitre.oauth2.repository.AuthorizationCodeRepository;
import org.mitre.util.jpa.JpaUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.Date;


@Repository
@Transactional(value="defaultTransactionManager")
public class JpaAuthorizationCodeRepository implements AuthorizationCodeRepository {

	@PersistenceContext(unitName="EXPERTS-MYSQL")
    EntityManager manager;

	
	@Override
	@Transactional(value="defaultTransactionManager")
	public AuthorizationCodeEntity save(AuthorizationCodeEntity authorizationCode) {

		return JpaUtil.saveOrUpdate(authorizationCode.getId(), manager, authorizationCode);

	}

	
	@Override
	@Transactional(value="defaultTransactionManager")
	public AuthorizationCodeEntity getByCode(String code) {
		TypedQuery<AuthorizationCodeEntity> query = manager.createNamedQuery(AuthorizationCodeEntity.QUERY_BY_VALUE, AuthorizationCodeEntity.class);
		query.setParameter("code", code);

		AuthorizationCodeEntity result = JpaUtil.getSingleResult(query.getResultList());
		return result;
	}

	
	@Override
	public void remove(AuthorizationCodeEntity authorizationCodeEntity) {
		AuthorizationCodeEntity found = manager.find(AuthorizationCodeEntity.class, authorizationCodeEntity.getId());
		if (found != null) {
			manager.remove(found);
		}
	}

	
	@Override
	public Collection<AuthorizationCodeEntity> getExpiredCodes() {
		TypedQuery<AuthorizationCodeEntity> query = manager.createNamedQuery(AuthorizationCodeEntity.QUERY_EXPIRATION_BY_DATE, AuthorizationCodeEntity.class);
		query.setParameter(AuthorizationCodeEntity.PARAM_DATE, new Date()); // this gets anything that's already expired
		return query.getResultList();
	}


	@Override
	public Collection<AuthorizationCodeEntity> getExpiredCodes(PageCriteria pageCriteria) {
		TypedQuery<AuthorizationCodeEntity> query = manager.createNamedQuery(AuthorizationCodeEntity.QUERY_EXPIRATION_BY_DATE, AuthorizationCodeEntity.class);
		query.setParameter(AuthorizationCodeEntity.PARAM_DATE, new Date()); // this gets anything that's already expired
		return JpaUtil.getResultPage(query, pageCriteria);
	}



}
