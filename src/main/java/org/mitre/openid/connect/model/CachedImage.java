

package org.mitre.openid.connect.model;

public class CachedImage {

	private byte[] data;
	private String contentType;
	private long length;

	/**
	 * @return the data
	 */
	public byte[] getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(byte[] data) {
		this.data = data;
	}
	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}
	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	/**
	 * @return the length
	 */
	public long getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(long length) {
		this.length = length;
	}

}
