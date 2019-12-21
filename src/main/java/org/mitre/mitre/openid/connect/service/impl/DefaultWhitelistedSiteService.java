
package org.mitre.mitre.openid.connect.service.impl;

import org.mitre.openid.connect.model.WhitelistedSite;
import org.mitre.openid.connect.repository.WhitelistedSiteRepository;
import org.mitre.openid.connect.service.WhitelistedSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional(value="defaultTransactionManager")
public class DefaultWhitelistedSiteService implements WhitelistedSiteService {

	@Autowired
	private WhitelistedSiteRepository repository;

	@Override
	public WhitelistedSite getById(Long id) {
		return repository.getById(id);
	}

	@Override
	public void remove(WhitelistedSite whitelistedSite) {
		repository.remove(whitelistedSite);
	}

	@Override
	public WhitelistedSite saveNew(WhitelistedSite whitelistedSite) {
		if (whitelistedSite.getId() != null) {
			throw new IllegalArgumentException("A new whitelisted site cannot be created with an id value already set: " + whitelistedSite.getId());
		}
		return repository.save(whitelistedSite);
	}

	@Override
	public Collection<WhitelistedSite> getAll() {
		return repository.getAll();
	}

	@Override
	public WhitelistedSite getByClientId(String clientId) {
		return repository.getByClientId(clientId);
	}

	@Override
	public WhitelistedSite update(WhitelistedSite oldWhitelistedSite, WhitelistedSite whitelistedSite) {
		if (oldWhitelistedSite == null || whitelistedSite == null) {
			throw new IllegalArgumentException("Neither the old or new sites may be null");
		}
		return repository.update(oldWhitelistedSite, whitelistedSite);
	}

}
