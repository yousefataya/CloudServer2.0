

package org.mitre.openid.connect.model.convert;

import com.google.common.base.Strings;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class JsonObjectStringConverter implements AttributeConverter<JsonObject, String> {

	private JsonParser parser = new JsonParser();

	@Override
	public String convertToDatabaseColumn(JsonObject attribute) {
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
	public JsonObject convertToEntityAttribute(String dbData) {
		if (!Strings.isNullOrEmpty(dbData)) {
			return parser.parse(dbData).getAsJsonObject();
		} else {
			return null;
		}
	}

}
