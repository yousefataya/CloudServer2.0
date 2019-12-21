
package org.mitre.mitre.openid.connect.view;

import com.google.common.base.Strings;
import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

@Component(JsonErrorView.VIEWNAME)
public class JsonErrorView extends AbstractView {

	public static final String ERROR_MESSAGE = "errorMessage";

	public static final String ERROR = "error";

	private static final Logger logger = LoggerFactory.getLogger(JsonErrorView.class);

	public static final String VIEWNAME = "jsonErrorView";

	private Gson gson = new GsonBuilder()
			.setExclusionStrategies(new ExclusionStrategy() {

				@Override
				public boolean shouldSkipField(FieldAttributes f) {

					return false;
				}

				@Override
				public boolean shouldSkipClass(Class<?> clazz) {
					// skip the JPA binding wrapper
					if (clazz.equals(BeanPropertyBindingResult.class)) {
						return true;
					}
					return false;
				}

			})
			.serializeNulls()
			.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
			.create();

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {

		response.setContentType(MediaType.APPLICATION_JSON_VALUE);


		HttpStatus code = (HttpStatus) model.get(HttpCodeView.CODE);
		if (code == null) {
			code = HttpStatus.INTERNAL_SERVER_ERROR; // default to 500
		}

		response.setStatus(code.value());

		try {

			Writer out = response.getWriter();

			String errorTitle = (String) model.get(ERROR);
			if (Strings.isNullOrEmpty(errorTitle)) {
				errorTitle = "mitreid_error";
			}
			String errorMessage = (String) model.get(ERROR_MESSAGE);
			JsonObject obj = new JsonObject();
			obj.addProperty("error", errorTitle);
			obj.addProperty("error_description", errorMessage);
			gson.toJson(obj, out);

		} catch (IOException e) {

			logger.error("IOException in JsonErrorView.java: ", e);

		}
	}

}
