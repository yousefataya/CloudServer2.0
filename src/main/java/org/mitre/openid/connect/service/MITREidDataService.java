
package org.mitre.openid.connect.service;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public interface MITREidDataService {

	/**
	 * Data member for 1.X configurations
	 */
	public static final String MITREID_CONNECT_1_0 = "mitreid-connect-1.0";
	public static final String MITREID_CONNECT_1_1 = "mitreid-connect-1.1";
	public static final String MITREID_CONNECT_1_2 = "mitreid-connect-1.2";
	public static final String MITREID_CONNECT_1_3 = "mitreid-connect-1.3";

	// member names
	public static final String REFRESHTOKENS = "refreshTokens";
	public static final String ACCESSTOKENS = "accessTokens";
	public static final String WHITELISTEDSITES = "whitelistedSites";
	public static final String BLACKLISTEDSITES = "blacklistedSites";
	public static final String AUTHENTICATIONHOLDERS = "authenticationHolders";
	public static final String GRANTS = "grants";
	public static final String CLIENTS = "clients";
	public static final String SYSTEMSCOPES = "systemScopes";

	/**
	 * Write out the current server state to the given JSON writer as a JSON object
	 *
	 * @param writer
	 * @throws IOException
	 */
	void exportData(JsonWriter writer) throws IOException;

	/**
	 * Read in the current server state from the given JSON reader as a JSON object
	 *
	 * @param reader
	 */
	void importData(JsonReader reader) throws IOException;

	/**
	 * Return true if the this data service supports the given version. This is called before
	 * handing the service the reader through its importData function.
	 *
	 * @param version
	 * @return
	 */
	boolean supportsVersion(String version);

}