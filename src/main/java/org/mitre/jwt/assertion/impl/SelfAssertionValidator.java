

package org.mitre.jwt.assertion.impl;

import com.google.common.base.Strings;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.mitre.jwt.assertion.AssertionValidator;
import org.mitre.jwt.signer.service.JWTSigningAndValidationService;
import org.mitre.openid.connect.config.ConfigurationPropertiesBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component("selfAssertionValidator")
public class SelfAssertionValidator implements AssertionValidator {

	private static Logger logger = LoggerFactory.getLogger(SelfAssertionValidator.class);

	@Autowired
	private ConfigurationPropertiesBean config;

	@Autowired
	private JWTSigningAndValidationService jwtService;

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

		// make sure the issuer exists
		if (Strings.isNullOrEmpty(claims.getIssuer())) {
			logger.debug("No issuer for assertion, rejecting");
			return false;
		}

		// make sure the issuer is us
		if (!claims.getIssuer().equals(config.getIssuer())) {
			logger.debug("Issuer is not the same as this server, rejecting");
			return false;
		}

		// validate the signature based on our public key
		if (jwtService.validateSignature((SignedJWT) assertion)) {
			return true;
		} else {
			return false;
		}

	}

}
