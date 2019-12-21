
package org.mitre.oauth2.repository;

import org.mitre.oauth2.model.ClientDetailsEntity;

import java.util.Collection;

public interface OAuth2ClientRepository {

	public ClientDetailsEntity getById(Long id);

	public ClientDetailsEntity getClientByClientId(String clientId);

	public ClientDetailsEntity saveClient(ClientDetailsEntity client);

	public void deleteClient(ClientDetailsEntity client);

	public ClientDetailsEntity updateClient(Long id, ClientDetailsEntity client);

	public Collection<ClientDetailsEntity> getAllClients();


}
