
package org.mitre.oauth2.repository;

import org.mitre.data.PageCriteria;
import org.mitre.oauth2.model.AuthenticationHolderEntity;

import java.util.List;

public interface AuthenticationHolderRepository {
	public List<AuthenticationHolderEntity> getAll();

	public AuthenticationHolderEntity getById(Long id);

	public void remove(AuthenticationHolderEntity a);

	public AuthenticationHolderEntity save(AuthenticationHolderEntity a);

	public List<AuthenticationHolderEntity> getOrphanedAuthenticationHolders();

	public List<AuthenticationHolderEntity> getOrphanedAuthenticationHolders(PageCriteria pageCriteria);
}
