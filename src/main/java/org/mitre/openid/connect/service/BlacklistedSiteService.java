
package org.mitre.openid.connect.service;

import org.mitre.openid.connect.model.BlacklistedSite;

import java.util.Collection;


public interface BlacklistedSiteService {

	public Collection<BlacklistedSite> getAll();

	public BlacklistedSite getById(Long id);

	public void remove(BlacklistedSite blacklistedSite);

	public BlacklistedSite saveNew(BlacklistedSite blacklistedSite);

	public BlacklistedSite update(BlacklistedSite oldBlacklistedSite, BlacklistedSite blacklistedSite);

	public boolean isBlacklisted(String uri);

}
