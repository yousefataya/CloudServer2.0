
package org.mitre.uma.service;

import org.mitre.oauth2.model.ClientDetailsEntity;
import org.mitre.uma.model.ResourceSet;

import java.util.Collection;

public interface ResourceSetService {

	public ResourceSet saveNew(ResourceSet rs);

	public ResourceSet getById(Long id);

	public ResourceSet update(ResourceSet oldRs, ResourceSet newRs);

	public void remove(ResourceSet rs);

	public Collection<ResourceSet> getAllForOwner(String owner);

	public Collection<ResourceSet> getAllForOwnerAndClient(String owner, String authClientId);

	public Collection<ResourceSet> getAllForClient(ClientDetailsEntity client);

}
