

package org.mitre.mitre.openid.connect.service.impl;

import org.mitre.oauth2.model.ClientDetailsEntity;
import org.mitre.uma.model.ResourceSet;
import org.mitre.uma.service.ResourceSetService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class DummyResourceSetService implements ResourceSetService {

	@Override
	public ResourceSet saveNew(ResourceSet rs) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ResourceSet getById(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ResourceSet update(ResourceSet oldRs, ResourceSet newRs) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void remove(ResourceSet rs) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<ResourceSet> getAllForOwner(String owner) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<ResourceSet> getAllForOwnerAndClient(String owner, String authClientId) {
		return Collections.emptySet();
	}

	@Override
	public Collection<ResourceSet> getAllForClient(ClientDetailsEntity client) {
		return Collections.emptySet();
	}

}
