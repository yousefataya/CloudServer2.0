
package org.mitre.oauth2.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.mitre.oauth2.model.convert.SerializableStringConverter;
import org.mitre.oauth2.model.convert.SimpleGrantedAuthorityStringConverter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "authentication_holder")
@NamedQueries({
	@NamedQuery(name = AuthenticationHolderEntity.QUERY_ALL, query = "select a from AuthenticationHolderEntity a"),
	@NamedQuery(name = AuthenticationHolderEntity.QUERY_GET_UNUSED, query = "select a from AuthenticationHolderEntity a where " +
			"a.id not in (select t.authenticationHolder.id from OAuth2AccessTokenEntity t) and " +
			"a.id not in (select r.authenticationHolder.id from OAuth2RefreshTokenEntity r) and " +
			"a.id not in (select c.authenticationHolder.id from AuthorizationCodeEntity c)")
})
public class AuthenticationHolderEntity {

	public static final String QUERY_GET_UNUSED = "AuthenticationHolderEntity.getUnusedAuthenticationHolders";
	public static final String QUERY_ALL = "AuthenticationHolderEntity.getAll";

	private Long id;

	private SavedUserAuthentication userAuth;

	private Collection<GrantedAuthority> roles;

	private Set<String> resourceIds;

	private boolean approved;

	private String redirectUri;

	private Set<String> responseTypes;


	@ElementCollection
	@MapKey(name="extensions")
	private Map<String, Serializable> extensions;

	private String clientId;

	private Set<String> scope;

	private Map<String, String> requestParameters;

	public AuthenticationHolderEntity() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Transient
	public OAuth2Authentication getAuthentication() {
		// TODO: memoize this
		return new OAuth2Authentication(createOAuth2Request(), getUserAuth());
	}

	private OAuth2Request createOAuth2Request() {
		return new OAuth2Request(requestParameters, clientId, roles, approved, scope, resourceIds, redirectUri, responseTypes, extensions);
	}

	public void setAuthentication(OAuth2Authentication authentication) {

		OAuth2Request o2Request = authentication.getOAuth2Request();
		setRoles(o2Request.getAuthorities() == null ? null : new HashSet<>(o2Request.getAuthorities()));
		setClientId(o2Request.getClientId());
		setExtensions(o2Request.getExtensions() == null ? null : new HashMap<>(o2Request.getExtensions()));
		setRedirectUri(o2Request.getRedirectUri());
		setRequestParameters(o2Request.getRequestParameters() == null ? null : new HashMap<>(o2Request.getRequestParameters()));
		setResourceIds(o2Request.getResourceIds() == null ? null : new HashSet<>(o2Request.getResourceIds()));
		setResponseTypes(o2Request.getResponseTypes() == null ? null : new HashSet<>(o2Request.getResponseTypes()));
		setScope(o2Request.getScope() == null ? null : new HashSet<>(o2Request.getScope()));
		setApproved(o2Request.isApproved());

		if (authentication.getUserAuthentication() != null) {
			this.userAuth = new SavedUserAuthentication(authentication.getUserAuthentication());
		} else {
			this.userAuth = null;
		}
	}

	/**
	 * @return the userAuth
	 */
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "user_auth_id")
	public SavedUserAuthentication getUserAuth() {
		return userAuth;
	}

	/**
	 * @param userAuth the userAuth to set
	 */
	public void setUserAuth(SavedUserAuthentication userAuth) {
		this.userAuth = userAuth;
	}

	/**
	 * @return the authorities
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
			name="authentication_holder_authority",
			joinColumns=@JoinColumn(name="owner_id")
			)
	@Convert(converter = SimpleGrantedAuthorityStringConverter.class)
	@Column(name="role")
	@Fetch(value = FetchMode.SUBSELECT)
	public Collection<GrantedAuthority> getRoles() {
		return roles;
	}

	/**
	 * @param roles the authorities to set
	 */
	public void setRoles(Collection<GrantedAuthority> roles) {
		this.roles = roles;
	}

	/**
	 * @return the resourceIds
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
			name="authentication_holder_resource_id",
			joinColumns=@JoinColumn(name="owner_id")
			)
	@Column(name="resource_id")
	public Set<String> getResourceIds() {
		return resourceIds;
	}

	/**
	 * @param resourceIds the resourceIds to set
	 */
	public void setResourceIds(Set<String> resourceIds) {
		this.resourceIds = resourceIds;
	}

	/**
	 * @return the approved
	 */
	@Basic
	@Column(name="approved")
	public boolean isApproved() {
		return approved;
	}

	/**
	 * @param approved the approved to set
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	/**
	 * @return the redirectUri
	 */
	@Basic
	@Column(name="redirect_uri")
	public String getRedirectUri() {
		return redirectUri;
	}

	/**
	 * @param redirectUri the redirectUri to set
	 */
	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	/**
	 * @return the responseTypes
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
			name="authentication_holder_response_type",
			joinColumns=@JoinColumn(name="owner_id")
			)
	@Column(name="response_type")
	public Set<String> getResponseTypes() {
		return responseTypes;
	}

	/**
	 * @param responseTypes the responseTypes to set
	 */
	public void setResponseTypes(Set<String> responseTypes) {
		this.responseTypes = responseTypes;
	}

	/**
	 * @return the extensions
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
			name="authentication_holder_extension",
			joinColumns=@JoinColumn(name="owner_id")
			)
	@Column(name="val")
	@MapKeyColumn(name="extensions")
	@Convert(converter= SerializableStringConverter.class , attributeName = "key")
	public Map<String, Serializable> getExtensions() {
		return extensions;
	}

	/**
	 * @param extensions the extensions to set
	 */
	public void setExtensions(Map<String, Serializable> extensions) {
		this.extensions = extensions;
	}

	/**
	 * @return the clientId
	 */
	@Basic
	@Column(name="client_id")
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the scope
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
			name="authentication_holder_scope",
			joinColumns=@JoinColumn(name="owner_id")
			)
	@Column(name="scope")
	public Set<String> getScope() {
		return scope;
	}

	/**
	 * @param scope the scope to set
	 */
	public void setScope(Set<String> scope) {
		this.scope = scope;
	}

	/**
	 * @return the requestParameters
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
			name="authentication_holder_request_parameter",
			joinColumns=@JoinColumn(name="owner_id")
			)
	@Column(name="val")
	@MapKeyColumn(name="param")
	public Map<String, String> getRequestParameters() {
		return requestParameters;
	}

	/**
	 * @param requestParameters the requestParameters to set
	 */
	public void setRequestParameters(Map<String, String> requestParameters) {
		this.requestParameters = requestParameters;
	}



}
