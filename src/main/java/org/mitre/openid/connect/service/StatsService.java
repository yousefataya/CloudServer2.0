
package org.mitre.openid.connect.service;

import org.mitre.openid.connect.model.ClientStat;

import java.util.Map;

public interface StatsService {

	/**
	 * Calculate summary statistics
	 *     	approvalCount: total approved sites
	 *      userCount: unique users
	 *      clientCount: unique clients
	 *
	 * @return
	 */
	public Map<String, Integer> getSummaryStats();

	/**
	 * Calculate the usage count for a single client
	 *
	 * @param clientId the id of the client to search on
	 * @return
	 */
	public ClientStat getCountForClientId(String clientId);

	/**
	 * Trigger the stats to be recalculated upon next update.
	 */
	public void resetCache();

}
