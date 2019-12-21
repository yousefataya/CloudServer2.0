

package org.mitre.uma.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "permission")
public class Permission {

	private Long id;
	private ResourceSet resourceSet;
	private Set<String> scopes;

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
	 * @return the resourceSet
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "resource_set_id")
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	/**
	 * @param resourceSet the resourceSet to set
	 */
	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	/**
	 * @return the scopes
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name = "scope")
	@CollectionTable(
			name = "permission_scope",
			joinColumns = @JoinColumn(name = "owner_id")
			)
	public Set<String> getScopes() {
		return scopes;
	}

	/**
	 * @param scopes the scopes to set
	 */
	public void setScopes(Set<String> scopes) {
		this.scopes = scopes;
	}
}