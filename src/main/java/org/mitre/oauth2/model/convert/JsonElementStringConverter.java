

package org.mitre.oauth2.model.convert;

import com.google.common.base.Strings;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class JsonElementStringConverter implements AttributeConverter<JsonElement, String> {

	private JsonParser parser = new JsonParser();

	@Override
	public String convertToDatabaseColumn(JsonElement attribute) {
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
	public JsonElement convertToEntityAttribute(String dbData) {
		if (!Strings.isNullOrEmpty(dbData)) {
			return parser.parse(dbData);
		} else {
			return null;
		}
	}

}
