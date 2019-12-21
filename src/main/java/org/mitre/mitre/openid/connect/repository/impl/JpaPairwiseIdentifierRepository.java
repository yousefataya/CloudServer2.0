
package org.mitre.mitre.openid.connect.repository.impl;

import org.mitre.openid.connect.model.PairwiseIdentifier;
import org.mitre.openid.connect.repository.PairwiseIdentifierRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import static org.mitre.util.jpa.JpaUtil.getSingleResult;
import static org.mitre.util.jpa.JpaUtil.saveOrUpdate;

@Repository
public class JpaPairwiseIdentifierRepository implements PairwiseIdentifierRepository {

	@PersistenceContext(unitName="EXPERTS-MYSQL")
	private EntityManager manager;

	/* (non-Javadoc)
	 * @see org.mitre.openid.connect.repository.PairwiseIdentifierRepository#getBySectorIdentifier(java.lang.String, java.lang.String)
	 */
	@Override
	public PairwiseIdentifier getBySectorIdentifier(String sub, String sectorIdentifierUri) {
		TypedQuery<PairwiseIdentifier> query = manager.createNamedQuery(PairwiseIdentifier.QUERY_BY_SECTOR_IDENTIFIER, PairwiseIdentifier.class);
		query.setParameter(PairwiseIdentifier.PARAM_SUB, sub);
		query.setParameter(PairwiseIdentifier.PARAM_SECTOR_IDENTIFIER, sectorIdentifierUri);

		return getSingleResult(query.getResultList());
	}

	/* (non-Javadoc)
	 * @see org.mitre.openid.connect.repository.PairwiseIdentifierRepository#save(org.mitre.openid.connect.model.PairwiseIdentifier)
	 */
	@Override
	@Transactional(value="defaultTransactionManager")
	public void save(PairwiseIdentifier pairwise) {
		saveOrUpdate(pairwise.getId(), manager, pairwise);
	}

}
