

package org.mitre.oauth2.model.convert;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.text.ParseException;

@Converter
public class JWTStringConverter implements AttributeConverter<JWT, String> {

	public static Logger logger = LoggerFactory.getLogger(JWTStringConverter.class);

	@Override
	public String convertToDatabaseColumn(JWT attribute) {
		if (attribute != null) {
			return attribute.serialize();
		} else {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.Object)
	 */
	@Override
	public JWT convertToEntityAttribute(String dbData) {
		if (dbData != null) {
			try {
				JWT jwt = JWTParser.parse(dbData);
				return jwt;
			} catch (ParseException e) {
				logger.error("Unable to parse JWT", e);
				return null;
			}
		} else {
			return null;
		}
	}

}
