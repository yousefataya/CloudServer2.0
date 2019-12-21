
package org.mitre.openid.connect.service;

import java.util.Set;

public interface ScopeClaimTranslationService {

	public Set<String> getClaimsForScope(String scope);

	public Set<String> getClaimsForScopeSet(Set<String> scopes);

}
