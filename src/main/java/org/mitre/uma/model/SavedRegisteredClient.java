

package org.mitre.uma.model;

import org.mitre.oauth2.model.RegisteredClient;
import org.mitre.uma.model.convert.RegisteredClientStringConverter;

import javax.persistence.*;

@Entity
@Table(name = "saved_registered_client")
public class SavedRegisteredClient {

	private Long id;
	private String issuer;
	private RegisteredClient registeredClient;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	/**
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the issuer
	 */
	@Basic
	@Column(name = "issuer")
	public String getIssuer() {
		return issuer;
	}

	/**
	 * @param issuer the issuer to set
	 */
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	/**
	 * @return the registeredClient
	 */
	@Basic
	@Column(name = "registered_client")
	@Convert(converter = RegisteredClientStringConverter.class)
	public RegisteredClient getRegisteredClient() {
		return registeredClient;
	}

	/**
	 * @param registeredClient the registeredClient to set
	 */
	public void setRegisteredClient(RegisteredClient registeredClient) {
		this.registeredClient = registeredClient;
	}



}
