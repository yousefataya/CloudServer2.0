

package org.mitre.oauth2.service;

import org.mitre.oauth2.exception.DeviceCodeCreationException;
import org.mitre.oauth2.model.ClientDetailsEntity;
import org.mitre.oauth2.model.DeviceCode;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.Map;
import java.util.Set;

public interface DeviceCodeService {

	/**
	 * @param userCode
	 * @return
	 */
	public DeviceCode lookUpByUserCode(String userCode);

	/**
	 * @param dc
	 * @param o2Auth
	 */
	public DeviceCode approveDeviceCode(DeviceCode dc, OAuth2Authentication o2Auth);

	/**
	 * @param deviceCode
	 * @param client
	 * @return
	 */
	public DeviceCode findDeviceCode(String deviceCode, ClientDetails client);


	/**
	 * 
	 * @param deviceCode
	 * @param client
	 */
	public void clearDeviceCode(String deviceCode, ClientDetails client);
	
	/**
	 * @param deviceCode
	 * @param userCode
	 * @param requestedScopes
	 * @param client
	 * @param parameters
	 * @return
	 */
	public DeviceCode createNewDeviceCode(Set<String> requestedScopes, ClientDetailsEntity client, Map<String, String> parameters) throws DeviceCodeCreationException;


	public void clearExpiredDeviceCodes();
}
