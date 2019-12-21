
package org.mitre.mitre.oauth2.repository.impl;

import org.mitre.oauth2.model.ClientDetailsEntity;
import org.mitre.oauth2.repository.OAuth2ClientRepository;
import org.mitre.util.jpa.JpaUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;


@Repository
@Transactional(value="defaultTransactionManager")
public class JpaOAuth2ClientRepository implements OAuth2ClientRepository {

	@PersistenceContext(unitName="EXPERTS-MYSQL")
	private EntityManager manager;

	public JpaOAuth2ClientRepository() {

	}

	public JpaOAuth2ClientRepository(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public ClientDetailsEntity getById(Long id) {
		return manager.find(ClientDetailsEntity.class, id);
	}

	/* (non-Javadoc)
	 * @see org.mitre.oauth2.repository.OAuth2ClientRepository#getClientById(java.lang.String)
	 */
	@Override
	public ClientDetailsEntity getClientByClientId(String clientId) {
		TypedQuery<ClientDetailsEntity> query = manager.createNamedQuery(ClientDetailsEntity.QUERY_BY_CLIENT_ID, ClientDetailsEntity.class);
		query.setParameter(ClientDetailsEntity.PARAM_CLIENT_ID, clientId);
		return JpaUtil.getSingleResult(query.getResultList());
	}

	/* (non-Javadoc)
	 * @see org.mitre.oauth2.repository.OAuth2ClientRepository#saveClient(org.mitre.oauth2.model.ClientDetailsEntity)
	 */
	@Override
	public ClientDetailsEntity saveClient(ClientDetailsEntity client) {
		return JpaUtil.saveOrUpdate(client.getClientId(), manager, client);
	}

	/* (non-Javadoc)
	 * @see org.mitre.oauth2.repository.OAuth2ClientRepository#deleteClient(org.mitre.oauth2.model.ClientDetailsEntity)
	 */
	@Override
	public void deleteClient(ClientDetailsEntity client) {
		ClientDetailsEntity found = getById(client.getId());
		if (found != null) {
			manager.remove(found);
		} else {
			throw new IllegalArgumentException("Client not found: " + client);
		}
	}

	@Override
	public ClientDetailsEntity updateClient(Long id, ClientDetailsEntity client) {
		// sanity check
		client.setId(id);

		return JpaUtil.saveOrUpdate(id, manager, client);
	}

	@Override
	public Collection<ClientDetailsEntity> getAllClients() {
		TypedQuery<ClientDetailsEntity> query = manager.createNamedQuery(ClientDetailsEntity.QUERY_ALL, ClientDetailsEntity.class);
		return query.getResultList();
	}

}
