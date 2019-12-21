
package org.mitre.openid.connect.model;

import javax.persistence.*;

@Entity
@Table(name="blacklisted_site")
@NamedQueries({
	@NamedQuery(name = BlacklistedSite.QUERY_ALL, query = "select b from BlacklistedSite b")
})
public class BlacklistedSite {

	public static final String QUERY_ALL = "BlacklistedSite.getAll";

	// unique id
	private Long id;

	// URI pattern to black list
	private String uri;

	public BlacklistedSite() {

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

	@Basic
	@Column(name="uri")
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}


}
