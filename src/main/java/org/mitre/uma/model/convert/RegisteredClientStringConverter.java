

package org.mitre.uma.model.convert;

import com.google.common.base.Strings;
import org.mitre.oauth2.model.RegisteredClient;
import org.mitre.openid.connect.ClientDetailsEntityJsonProcessor;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RegisteredClientStringConverter implements AttributeConverter<RegisteredClient, String> {

	/* (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.Object)
	 */
	@Override
	public String convertToDatabaseColumn(RegisteredClient attribute) {
		if (attribute == null || attribute.getSource() == null) {
			return null;
		} else {
			return attribute.getSource().toString();
		}

	}

	/* (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.Object)
	 */
	@Override
	public RegisteredClient convertToEntityAttribute(String dbData) {
		if (Strings.isNullOrEmpty(dbData)) {
			return null;
		} else {
			return ClientDetailsEntityJsonProcessor.parseRegistered(dbData);
		}
	}

}
