

package org.mitre.oauth2.model.convert;

import com.nimbusds.jose.jwk.JWKSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.text.ParseException;

@Converter
public class JWKSetStringConverter implements AttributeConverter<JWKSet, String> {

	private static Logger logger = LoggerFactory.getLogger(JWKSetStringConverter.class);

	@Override
	public String convertToDatabaseColumn(JWKSet attribute) {
		if (attribute != null) {
			return attribute.toString();
		} else {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.Object)
	 */
	@Override
	public JWKSet convertToEntityAttribute(String dbData) {
		if (dbData != null) {
			try {
				JWKSet jwks = JWKSet.parse(dbData);
				return jwks;
			} catch (ParseException e) {
				logger.error("Unable to parse JWK Set", e);
				return null;
			}
		} else {
			return null;
		}

	}

}
