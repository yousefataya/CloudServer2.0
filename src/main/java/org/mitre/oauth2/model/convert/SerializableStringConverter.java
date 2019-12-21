

package org.mitre.oauth2.model.convert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.Serializable;
import java.util.Date;


@Converter
public class SerializableStringConverter implements AttributeConverter<Serializable, String> {

	private static Logger logger = LoggerFactory.getLogger(SerializableStringConverter.class);

	@Override
	public String convertToDatabaseColumn(Serializable attribute) {
		if (attribute == null) {
			return null;
		} else if (attribute instanceof String) {
			return (String) attribute;
		} else if (attribute instanceof Long) {
			return attribute.toString();
		} else if (attribute instanceof Date) {
			return Long.toString(((Date)attribute).getTime());
		} else {
			logger.warn("Dropping data from request: " + attribute + " :: " + attribute.getClass());
			return null;
		}
	}

	@Override
	public Serializable convertToEntityAttribute(String dbData) {
		return dbData;
	}

}
