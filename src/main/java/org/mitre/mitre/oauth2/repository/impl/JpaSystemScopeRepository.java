
package org.mitre.mitre.oauth2.repository.impl;

import org.mitre.oauth2.model.SystemScope;
import org.mitre.oauth2.repository.SystemScopeRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.mitre.util.jpa.JpaUtil.getSingleResult;
import static org.mitre.util.jpa.JpaUtil.saveOrUpdate;


@Repository("jpaSystemScopeRepository")
public class JpaSystemScopeRepository implements SystemScopeRepository {

	@PersistenceContext(unitName="EXPERTS-MYSQL")
	private EntityManager em;

	/* (non-Javadoc)
	 * @see org.mitre.oauth2.repository.SystemScopeRepository#getAll()
	 */
	@Override
	@Transactional(value="defaultTransactionManager")
	public Set<SystemScope> getAll() {
		TypedQuery<SystemScope> query = em.createNamedQuery(SystemScope.QUERY_ALL, SystemScope.class);

		return new LinkedHashSet<>(query.getResultList());
	}

	/* (non-Javadoc)
	 * @see org.mitre.oauth2.repository.SystemScopeRepository#getById(java.lang.Long)
	 */
	@Override
	@Transactional(value="defaultTransactionManager")
	public SystemScope getById(Long id) {
		return em.find(SystemScope.class, id);
	}

	/* (non-Javadoc)
	 * @see org.mitre.oauth2.repository.SystemScopeRepository#getByValue(java.lang.String)
	 */
	@Override
	@Transactional(value="defaultTransactionManager")
	public SystemScope getByValue(String value) {
		TypedQuery<SystemScope> query = em.createNamedQuery(SystemScope.QUERY_BY_VALUE, SystemScope.class);
		query.setParameter(SystemScope.PARAM_VALUE, value);
		return getSingleResult(query.getResultList());
	}

	/* (non-Javadoc)
	 * @see org.mitre.oauth2.repository.SystemScopeRepository#remove(org.mitre.oauth2.model.SystemScope)
	 */
	@Override
	@Transactional(value="defaultTransactionManager")
	public void remove(SystemScope scope) {
		SystemScope found = getById(scope.getId());

		if (found != null) {
			em.remove(found);
		}

	}

	/* (non-Javadoc)
	 * @see org.mitre.oauth2.repository.SystemScopeRepository#save(org.mitre.oauth2.model.SystemScope)
	 */
	@Override
	@Transactional(value="defaultTransactionManager")
	public SystemScope save(SystemScope scope) {
		return saveOrUpdate(scope.getId(), em, scope);
	}

}
