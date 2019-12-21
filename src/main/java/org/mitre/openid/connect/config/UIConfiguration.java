

package org.mitre.openid.connect.config;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UIConfiguration {

	private Set<String> jsFiles;

	/**
	 * @return the jsFiles
	 */
	public Set<String> getJsFiles() {
		return jsFiles;
	}
	/**
	 * @param jsFiles the jsFiles to set
	 */
	public void setJsFiles(Set<String> jsFiles) {
		this.jsFiles = jsFiles;
	}

}
