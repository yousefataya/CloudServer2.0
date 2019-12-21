

package org.mitre.oauth2.model.convert;

import com.nimbusds.jose.JWEAlgorithm;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class JWEAlgorithmStringConverter implements AttributeConverter<JWEAlgorithm, String> {

	@Override
	public String convertToDatabaseColumn(JWEAlgorithm attribute) {
		if (attribute != null) {
			return attribute.getName();
		} else {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.Object)
	 */
	@Override
	public JWEAlgorithm convertToEntityAttribute(String dbData) {
		if (dbData != null) {
			return JWEAlgorithm.parse(dbData);
		} else {
			return null;
		}
	}
}