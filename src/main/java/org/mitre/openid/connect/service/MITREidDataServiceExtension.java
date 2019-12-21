

package org.mitre.openid.connect.service;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public interface MITREidDataServiceExtension {

	/**
	 * Export any data for this extension. This is called from the top level object.
	 * All extensions MUST return the writer to a state such that another member of
	 * the top level object can be written next.
	 *
	 * @param writer
	 */
	void exportExtensionData(JsonWriter writer) throws IOException;

	/**
	 * Import data that's part of this extension. This is called from the context of
	 * reading the top level object. All extensions MUST return the reader to a state
	 * such that another member of the top level object can be read next. The name of
	 * the data element being imported is passed in as name. If the extension does not
	 * support this data element, it must return without advancing the reader.
	 *
	 * Returns "true" if the item was processed, "false" otherwise.
	 *
	 * @param reader
	 */
	boolean importExtensionData(String name, JsonReader reader) throws IOException;

	/**
	 * Signal the extension to wrap up all object processing and finalize its
	 */
	void fixExtensionObjectReferences(MITREidDataServiceMaps maps);

	/**
	 * Return
	 * @param mitreidConnect13
	 * @return
	 */
	boolean supportsVersion(String version);

}
