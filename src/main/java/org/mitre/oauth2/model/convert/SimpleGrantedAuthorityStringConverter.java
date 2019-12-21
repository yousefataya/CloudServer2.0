
package org.mitre.oauth2.model.convert;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SimpleGrantedAuthorityStringConverter implements AttributeConverter<SimpleGrantedAuthority, String> {

	@Override
	public String convertToDatabaseColumn(SimpleGrantedAuthority attribute) {
		if (attribute != null) {
			return attribute.getAuthority();
		} else {
			return null;
		}
	}

	@Override
	public SimpleGrantedAuthority convertToEntityAttribute(String dbData) {
		if (dbData != null) {
			return new SimpleGrantedAuthority(dbData);
		} else {
			return null;
		}
	}

}
