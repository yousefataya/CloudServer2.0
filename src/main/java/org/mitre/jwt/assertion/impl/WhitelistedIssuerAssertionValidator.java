

package org.mitre.jwt.assertion.impl;

import com.google.common.base.Strings;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.NoArgsConstructor;
import org.mitre.jwt.assertion.AssertionValidator;
import org.mitre.jwt.signer.service.JWTSigningAndValidationService;
import org.mitre.jwt.signer.service.impl.JWKSetCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@Service("jwtAssertionValidator")
@Component
@NoArgsConstructor
public class WhitelistedIssuerAssertionValidator implements AssertionValidator {

	private static Logger logger = LoggerFactory.getLogger(WhitelistedIssuerAssertionValidator.class);

	/**
	 * Map of issuer -> JWKSetUri
	 */
	private Map<String, String> whitelist = new HashMap<>();

	/**
	 * @return the whitelist
	 */
	public Map<String, String> getWhitelist() {
		return whitelist;
	}

	/**
	 * @param whitelist the whitelist to set
	 */
	public void setWhitelist(Map<String, String> whitelist) {
		this.whitelist = whitelist;
	}

	@Autowired
	private JWKSetCacheService jwkCache;

	@Override
	public boolean isValid(JWT assertion) {

		if (!(assertion instanceof SignedJWT)) {
			// unsigned assertion
			return false;
		}

		JWTClaimsSet claims;
		try {
			claims = assertion.getJWTClaimsSet();
		} catch (ParseException e) {
			logger.debug("Invalid assertion claims");
			return false;
		}

		if (Strings.isNullOrEmpty(claims.getIssuer())) {
			logger.debug("No issuer for assertion, rejecting");
			return false;
		}

		if (!whitelist.containsKey(claims.getIssuer())) {
			logger.debug("Issuer is not in whitelist, rejecting");
			return false;
		}

		String jwksUri = whitelist.get(claims.getIssuer());

		JWTSigningAndValidationService validator = jwkCache.getValidator(jwksUri);

		if (validator.validateSignature((SignedJWT) assertion)) {
			return true;
		} else {
			return false;
		}

	}

}
