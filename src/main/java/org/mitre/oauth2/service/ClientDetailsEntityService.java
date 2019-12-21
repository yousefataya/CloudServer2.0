
package org.mitre.oauth2.service;

import org.mitre.oauth2.model.ClientDetailsEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.ClientDetailsService;

import java.util.Collection;

public interface ClientDetailsEntityService extends ClientDetailsService {

	public ClientDetailsEntity saveNewClient(ClientDetailsEntity client);

	public ClientDetailsEntity getClientById(Long id);

	@Override
	public ClientDetailsEntity loadClientByClientId(String clientId) throws OAuth2Exception;

	public void deleteClient(ClientDetailsEntity client);

	public ClientDetailsEntity updateClient(ClientDetailsEntity oldClient, ClientDetailsEntity newClient);

	public Collection<ClientDetailsEntity> getAllClients();

	public ClientDetailsEntity generateClientId(ClientDetailsEntity client);

	public ClientDetailsEntity generateClientSecret(ClientDetailsEntity client);

}
