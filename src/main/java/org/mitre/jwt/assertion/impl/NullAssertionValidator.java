

package org.mitre.jwt.assertion.impl;

import com.nimbusds.jwt.JWT;
import org.mitre.jwt.assertion.AssertionValidator;

public class NullAssertionValidator implements AssertionValidator {

	/**
	 * Reject all assertions passed in, always returns false.
	 */
	@Override
	public boolean isValid(JWT assertion) {
		return false;

	}

}
