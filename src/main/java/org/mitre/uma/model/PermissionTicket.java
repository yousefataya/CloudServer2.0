

package org.mitre.uma.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "permission_ticket")
@NamedQueries({
	@NamedQuery(name = PermissionTicket.QUERY_TICKET, query = "select p from PermissionTicket p where p.ticket = :" + PermissionTicket.PARAM_TICKET),
	@NamedQuery(name = PermissionTicket.QUERY_ALL, query = "select p from PermissionTicket p"),
	@NamedQuery(name = PermissionTicket.QUERY_BY_RESOURCE_SET, query = "select p from PermissionTicket p where p.permission.resourceSet.id = :" + PermissionTicket.PARAM_RESOURCE_SET_ID)
})
public class PermissionTicket {

	public static final String QUERY_TICKET = "PermissionTicket.queryByTicket";
	public static final String QUERY_ALL = "PermissionTicket.queryAll";
	public static final String QUERY_BY_RESOURCE_SET = "PermissionTicket.queryByResourceSet";

	public static final String PARAM_TICKET = "ticket";
	public static final String PARAM_RESOURCE_SET_ID = "rsid";

	private Long id;
	private Permission permission;
	private String ticket;
	private Date expiration;
	private Collection<Claim> claimsSupplied;

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
	 * @return the permission
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "permission_id")
	public Permission getPermission() {
		return permission;
	}

	/**
	 * @param permission the permission to set
	 */
	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	/**
	 * @return the ticket
	 */
	@Basic
	@Column(name = "ticket")
	public String getTicket() {
		return ticket;
	}

	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	/**
	 * @return the expiration
	 */
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expiration")
	public Date getExpiration() {
		return expiration;
	}

	/**
	 * @param expiration the expiration to set
	 */
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	/**
	 * @return the claimsSupplied
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "claim_to_permission_ticket",
			joinColumns = @JoinColumn(name = "permission_ticket_id"),
			inverseJoinColumns = @JoinColumn(name = "claim_id")
			)
	public Collection<Claim> getClaimsSupplied() {
		return claimsSupplied;
	}

	/**
	 * @param claimsSupplied the claimsSupplied to set
	 */
	public void setClaimsSupplied(Collection<Claim> claimsSupplied) {
		this.claimsSupplied = claimsSupplied;
	}


}
