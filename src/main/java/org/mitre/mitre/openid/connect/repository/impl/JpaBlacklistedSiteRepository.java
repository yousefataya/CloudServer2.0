
package org.mitre.mitre.openid.connect.repository.impl;

import org.mitre.openid.connect.model.BlacklistedSite;
import org.mitre.openid.connect.repository.BlacklistedSiteRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

import static org.mitre.util.jpa.JpaUtil.saveOrUpdate;

@Repository
public class JpaBlacklistedSiteRepository implements BlacklistedSiteRepository {

	@PersistenceContext(unitName="EXPERTS-MYSQL")
	private EntityManager manager;

	/* (non-Javadoc)
	 * @see org.mitre.openid.connect.repository.BlacklistedSiteRepository#getAll()
	 */
	@Override
	@Transactional(value="defaultTransactionManager")
	public Collection<BlacklistedSite> getAll() {
		TypedQuery<BlacklistedSite> query = manager.createNamedQuery(BlacklistedSite.QUERY_ALL, BlacklistedSite.class);
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see org.mitre.openid.connect.repository.BlacklistedSiteRepository#getById(java.lang.Long)
	 */
	@Override
	@Transactional(value="defaultTransactionManager")
	public BlacklistedSite getById(Long id) {
		return manager.find(BlacklistedSite.class, id);
	}

	/* (non-Javadoc)
	 * @see org.mitre.openid.connect.repository.BlacklistedSiteRepository#remove(org.mitre.openid.connect.model.BlacklistedSite)
	 */
	@Override
	@Transactional(value="defaultTransactionManager")
	public void remove(BlacklistedSite blacklistedSite) {
		BlacklistedSite found = manager.find(BlacklistedSite.class, blacklistedSite.getId());

		if (found != null) {
			manager.remove(found);
		} else {
			throw new IllegalArgumentException();
		}

	}

	/* (non-Javadoc)
	 * @see org.mitre.openid.connect.repository.BlacklistedSiteRepository#save(org.mitre.openid.connect.model.BlacklistedSite)
	 */
	@Override
	@Transactional(value="defaultTransactionManager")
	public BlacklistedSite save(BlacklistedSite blacklistedSite) {
		return saveOrUpdate(blacklistedSite.getId(), manager, blacklistedSite);
	}

	/* (non-Javadoc)
	 * @see org.mitre.openid.connect.repository.BlacklistedSiteRepository#update(org.mitre.openid.connect.model.BlacklistedSite, org.mitre.openid.connect.model.BlacklistedSite)
	 */
	@Override
	@Transactional(value="defaultTransactionManager")
	public BlacklistedSite update(BlacklistedSite oldBlacklistedSite, BlacklistedSite blacklistedSite) {

		blacklistedSite.setId(oldBlacklistedSite.getId());
		return saveOrUpdate(oldBlacklistedSite.getId(), manager, blacklistedSite);

	}

}
