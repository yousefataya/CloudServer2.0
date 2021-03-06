
package org.mitre.mitre.openid.connect.assertion;

import com.nimbusds.jwt.JWT;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.text.ParseException;
import java.util.Collection;

public class JWTBearerAssertionAuthenticationToken extends AbstractAuthenticationToken {

	/**
	 *
	 */
	private static final long serialVersionUID = -3138213539914074617L;
	private String subject;
	private JWT jwt;

	/**
	 * Create an unauthenticated token with the given subject and jwt
	 * @param subject
	 * @param jwt
	 */
	public JWTBearerAssertionAuthenticationToken(JWT jwt) {
		super(null);
		try {
			// save the subject of the JWT in case the credentials get erased later
			this.subject = jwt.getJWTClaimsSet().getSubject();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.jwt = jwt;
		setAuthenticated(false);
	}

	/**
	 * Create an authenticated token with the given clientID, jwt, and authorities set
	 * @param subject
	 * @param jwt
	 * @param authorities
	 */
	public JWTBearerAssertionAuthenticationToken(JWT jwt, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		try {
			// save the subject of the JWT in case the credentials get erased later
			this.subject = jwt.getJWTClaimsSet().getSubject();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.jwt = jwt;
		setAuthenticated(true);
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.Authentication#getCredentials()
	 */
	@Override
	public Object getCredentials() {
		return jwt;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.Authentication#getPrincipal()
	 */
	@Override
	public Object getPrincipal() {
		return subject;
	}

	/**
	 * @return the jwt
	 */
	public JWT getJwt() {
		return jwt;
	}

	/**
	 * @param jwt the jwt to set
	 */
	public void setJwt(JWT jwt) {
		this.jwt = jwt;
	}

	/**
	 * Clear out the JWT that this token holds.
	 */
	@Override
	public void eraseCredentials() {
		super.eraseCredentials();
		setJwt(null);
	}



}
