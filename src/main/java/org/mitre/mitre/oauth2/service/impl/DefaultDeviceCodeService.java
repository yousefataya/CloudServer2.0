
package org.mitre.mitre.oauth2.service.impl;

import org.mitre.data.AbstractPageOperationTemplate;
import org.mitre.oauth2.model.AuthenticationHolderEntity;
import org.mitre.oauth2.model.ClientDetailsEntity;
import org.mitre.oauth2.model.DeviceCode;
import org.mitre.oauth2.repository.impl.DeviceCodeRepository;
import org.mitre.oauth2.service.DeviceCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("defaultDeviceCodeService")
public class DefaultDeviceCodeService implements DeviceCodeService {

	@Autowired
	private DeviceCodeRepository repository;

	private RandomValueStringGenerator randomGenerator = new RandomValueStringGenerator();

	
	@Override
	public DeviceCode createNewDeviceCode(Set<String> requestedScopes, ClientDetailsEntity client, Map<String, String> parameters) {

		// create a device code, should be big and random
		String deviceCode = UUID.randomUUID().toString();

		// create a user code, should be random but small and typable, and always uppercase (lookup is case insensitive)
		String userCode = randomGenerator.generate().toUpperCase();

		DeviceCode dc = new DeviceCode(deviceCode, userCode, requestedScopes, client.getClientId(), parameters);

		if (client.getDeviceCodeValiditySeconds() != null) {
			dc.setExpiration(new Date(System.currentTimeMillis() + client.getDeviceCodeValiditySeconds() * 1000L));
		}

		dc.setApproved(false);

		return repository.save(dc);
	}

	
	@Override
	public DeviceCode lookUpByUserCode(String userCode) {
		// always up-case the code for lookup
		return repository.getByUserCode(userCode.toUpperCase());
	}

	@Override
	public DeviceCode approveDeviceCode(DeviceCode dc, OAuth2Authentication auth) {
		DeviceCode found = repository.getById(dc.getId());

		found.setApproved(true);

		AuthenticationHolderEntity authHolder = new AuthenticationHolderEntity();
		authHolder.setAuthentication(auth);

		found.setAuthenticationHolder(authHolder);

		return repository.save(found);
	}

	@Override
	public DeviceCode findDeviceCode(String deviceCode, ClientDetails client) {
		DeviceCode found = repository.getByDeviceCode(deviceCode);

		if (found != null) {
			if (found.getClientId().equals(client.getClientId())) {
				// make sure the client matches, if so, we're good
				return found;
			} else {
				// if the clients don't match, pretend the code wasn't found
				return null;
			}
		} else {
			// didn't find the code, return null
			return null;
		}

	}


	@Override
	@Transactional(value="defaultTransactionManager")
	public void clearExpiredDeviceCodes() {

		new AbstractPageOperationTemplate<DeviceCode>("clearExpiredDeviceCodes"){
			@Override
			public Collection<DeviceCode> fetchPage() {
				return repository.getExpiredCodes();
			}

			@Override
			protected void doOperation(DeviceCode item) {
				repository.remove(item);
			}
		}.execute();
	}

	@Override
	public void clearDeviceCode(String deviceCode, ClientDetails client) {
		DeviceCode found = findDeviceCode(deviceCode, client);
		
		if (found != null) {
			// make sure it's not used twice
			repository.remove(found);
		}

	}

}
