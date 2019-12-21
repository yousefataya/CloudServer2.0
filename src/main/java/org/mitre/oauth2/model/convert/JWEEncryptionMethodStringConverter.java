

package org.mitre.oauth2.model.convert;

import com.nimbusds.jose.EncryptionMethod;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class JWEEncryptionMethodStringConverter implements AttributeConverter<EncryptionMethod, String> {

	@Override
	public String convertToDatabaseColumn(EncryptionMethod attribute) {
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
	public EncryptionMethod convertToEntityAttribute(String dbData) {
		if (dbData != null) {
			return EncryptionMethod.parse(dbData);
		} else {
			return null;
		}
	}
}