
package org.mitre.oauth2.repository;

import org.mitre.oauth2.model.SystemScope;

import java.util.Set;

public interface SystemScopeRepository {

	public Set<SystemScope> getAll();

	public SystemScope getById(Long id);

	public SystemScope getByValue(String value);

	public void remove(SystemScope scope);

	public SystemScope save(SystemScope scope);

}
