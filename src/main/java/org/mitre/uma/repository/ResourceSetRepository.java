

package org.mitre.uma.repository;

import org.mitre.uma.model.ResourceSet;

import java.util.Collection;

public interface ResourceSetRepository {

	public ResourceSet save(ResourceSet rs);

	public ResourceSet getById(Long id);

	public void remove(ResourceSet rs);

	public Collection<ResourceSet> getAllForOwner(String owner);

	public Collection<ResourceSet> getAllForOwnerAndClient(String owner, String clientId);

	public Collection<ResourceSet> getAll();

	public Collection<ResourceSet> getAllForClient(String clientId);

}
