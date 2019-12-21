
package org.mitre.oauth2.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "authorization_code")
@NamedQueries({
	@NamedQuery(name = AuthorizationCodeEntity.QUERY_BY_VALUE, query = "select a from AuthorizationCodeEntity a where a.code = :code"),
	@NamedQuery(name = AuthorizationCodeEntity.QUERY_EXPIRATION_BY_DATE, query = "select a from AuthorizationCodeEntity a where a.expiration <= :" + AuthorizationCodeEntity.PARAM_DATE)
})
public class AuthorizationCodeEntity {

	public static final String QUERY_BY_VALUE = "AuthorizationCodeEntity.getByValue";
	public static final String QUERY_EXPIRATION_BY_DATE = "AuthorizationCodeEntity.expirationByDate";

	public static final String PARAM_DATE = "date";

	private Long id;

	private String code;

	private AuthenticationHolderEntity authenticationHolder;

	private Date expiration;

	/**
	 * Default constructor.
	 */
	public AuthorizationCodeEntity() {

	}

	/**
	 * Create a new AuthorizationCodeEntity with the given code and AuthorizationRequestHolder.
	 *
	 * @param code 			the authorization code
	 * @param authRequest	the AuthoriztionRequestHolder associated with the original code request
	 */
	public AuthorizationCodeEntity(String code, AuthenticationHolderEntity authenticationHolder, Date expiration) {
		this.code = code;
		this.authenticationHolder = authenticationHolder;
		this.expiration = expiration;
	}

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
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	@Basic
	@Column(name = "code")
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * The authentication in place when this token was created.
	 * @return the authentication
	 */
	@ManyToOne
	@JoinColumn(name = "auth_holder_id")
	public AuthenticationHolderEntity getAuthenticationHolder() {
		return authenticationHolder;
	}

	/**
	 * @param authentication the authentication to set
	 */
	public void setAuthenticationHolder(AuthenticationHolderEntity authenticationHolder) {
		this.authenticationHolder = authenticationHolder;
	}

	@Basic
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@Column(name = "expiration")
	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
}
