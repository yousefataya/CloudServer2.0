

package org.mitre.openid.connect.config;

import com.google.common.base.Strings;
import com.nimbusds.jose.jwk.JWKSet;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;

@Component
public class JWKSetEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (!Strings.isNullOrEmpty(text)) {
			try {
				setValue(JWKSet.parse(text));
			} catch (ParseException e) {
				throw new IllegalArgumentException(e);
			}
		} else {
			setValue(null);
		}
	}

}
