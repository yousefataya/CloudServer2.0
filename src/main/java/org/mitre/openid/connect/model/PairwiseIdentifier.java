
package org.mitre.openid.connect.model;

import javax.persistence.*;

@Entity
@Table(name = "pairwise_identifier")
@NamedQueries({
	@NamedQuery(name= PairwiseIdentifier.QUERY_ALL, query = "select p from PairwiseIdentifier p"),
	@NamedQuery(name= PairwiseIdentifier.QUERY_BY_SECTOR_IDENTIFIER, query = "select p from PairwiseIdentifier p WHERE p.userSub = :" + PairwiseIdentifier.PARAM_SUB + " AND p.sectorIdentifier = :" + PairwiseIdentifier.PARAM_SECTOR_IDENTIFIER)
})
public class PairwiseIdentifier {

	public static final String QUERY_BY_SECTOR_IDENTIFIER = "PairwiseIdentifier.getBySectorIdentifier";
	public static final String QUERY_ALL = "PairwiseIdentifier.getAll";

	public static final String PARAM_SECTOR_IDENTIFIER = "sectorIdentifier";
	public static final String PARAM_SUB = "sub";

	private Long id;
	private String identifier;
	private String userSub;
	private String sectorIdentifier;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
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
	 * @return the identifier
	 */
	@Basic
	@Column(name = "identifier")
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the userSub
	 */
	@Basic
	@Column(name = PairwiseIdentifier.PARAM_SUB)
	public String getUserSub() {
		return userSub;
	}

	/**
	 * @param userSub the userSub to set
	 */
	public void setUserSub(String userSub) {
		this.userSub = userSub;
	}

	/**
	 * @return the sectorIdentifier
	 */
	@Basic
	@Column(name = "sector_identifier")
	public String getSectorIdentifier() {
		return sectorIdentifier;
	}

	/**
	 * @param sectorIdentifier the sectorIdentifier to set
	 */
	public void setSectorIdentifier(String sectorIdentifier) {
		this.sectorIdentifier = sectorIdentifier;
	}
}
