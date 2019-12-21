

package org.mitre.oauth2.model;

import org.mitre.oauth2.model.convert.SimpleGrantedAuthorityStringConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name="saved_user_auth")
public class SavedUserAuthentication implements Authentication {

	private static final long serialVersionUID = -1804249963940323488L;

	private Long id;

	private String name;

	@ElementCollection
	@MapKey(name="authorityCollection")
	private Collection<GrantedAuthority> authorityCollection;

	private boolean authenticated;

	private String sourceClass;

	/**
	 * Create a Saved Auth from an existing Auth token
	 */
	public SavedUserAuthentication(Authentication src) {
		setName(src.getName());
		setAuthorities(new HashSet<>(src.getAuthorities()));
		setAuthenticated(src.isAuthenticated());

		if (src instanceof SavedUserAuthentication) {
			// if we're copying in a saved auth, carry over the original class name
			setSourceClass(((SavedUserAuthentication) src).getSourceClass());
		} else {
			setSourceClass(src.getClass().getName());
		}
	}

	/**
	 * Create an empty saved auth
	 */
	public SavedUserAuthentication() {

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

	@Override
	@Basic
	@Column(name="name")
	public String getName() {
		return name;
	}

	@Override
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
			name="saved_user_auth_authority",
			joinColumns=@JoinColumn(name="owner_id")
			)
	@Convert(converter = SimpleGrantedAuthorityStringConverter.class , attributeName = "authorityCollection")
	@Column(name="authorityCollection")
	public Collection<GrantedAuthority> getAuthorities() {
		return authorityCollection;
	}

	@Override
	@Transient
	public Object getCredentials() {
		return "";
	}

	@Override
	@Transient
	public Object getDetails() {
		return null;
	}

	@Override
	@Transient
	public Object getPrincipal() {
		return getName();
	}

	@Override
	@Basic
	@Column(name="authenticated")
	public boolean isAuthenticated() {
		return authenticated;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		this.authenticated = isAuthenticated;
	}

	/**
	 * @return the sourceClass
	 */
	@Basic
	@Column(name="source_class")
	public String getSourceClass() {
		return sourceClass;
	}

	/**
	 * @param sourceClass the sourceClass to set
	 */
	public void setSourceClass(String sourceClass) {
		this.sourceClass = sourceClass;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorityCollection = authorities;
	}


}
