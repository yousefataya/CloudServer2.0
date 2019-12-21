

package org.mitre.oauth2.exception;

public class DeviceCodeCreationException extends Exception {

	private static final long serialVersionUID = 8078568710169208466L;

	private String error;

	public DeviceCodeCreationException(String error, String message) {
		super(message);
		this.error = error;
	}
	
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	
	
	
}
