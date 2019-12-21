

package org.mitre.jwt.assertion;

import com.nimbusds.jwt.JWT;

public interface AssertionValidator {

	public boolean isValid(JWT assertion);

}
