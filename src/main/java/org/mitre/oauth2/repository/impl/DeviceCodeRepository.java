

package org.mitre.oauth2.repository.impl;

import org.mitre.oauth2.model.DeviceCode;

import java.util.Collection;

public interface DeviceCodeRepository {

	/**
	 * @param id
	 * @return
	 */
	public DeviceCode getById(Long id);

	/**
	 * @param deviceCode
	 * @return
	 */
	public DeviceCode getByDeviceCode(String deviceCode);

	/**
	 * @param scope
	 */
	public void remove(DeviceCode scope);

	/**
	 * @param scope
	 * @return
	 */
	public DeviceCode save(DeviceCode scope);

	/**
	 * @param userCode
	 * @return
	 */
	public DeviceCode getByUserCode(String userCode);

	/**
	 * @return
	 */
	public Collection<DeviceCode> getExpiredCodes();

}
