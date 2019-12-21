

package org.mitre.openid.connect.service;

import org.mitre.oauth2.model.ClientDetailsEntity;
import org.mitre.openid.connect.model.CachedImage;

public interface ClientLogoLoadingService {

	/**
	 * @param client
	 * @return
	 */
	public CachedImage getLogo(ClientDetailsEntity client);

}
