

package org.mitre.oauth2.model.convert;

import com.nimbusds.jose.JWSAlgorithm;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class JWSAlgorithmStringConverter implements AttributeConverter<JWSAlgorithm, String> {

	@Override
	public String convertToDatabaseColumn(JWSAlgorithm attribute) {
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
	public JWSAlgorithm convertToEntityAttribute(String dbData) {
		if (dbData != null) {
			return JWSAlgorithm.parse(dbData);
		} else {
			return null;
		}
	}
}