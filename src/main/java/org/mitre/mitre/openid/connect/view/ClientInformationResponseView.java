
package org.mitre.mitre.openid.connect.view;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import org.mitre.oauth2.model.RegisteredClient;
import org.mitre.openid.connect.ClientDetailsEntityJsonProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

@Component(ClientInformationResponseView.VIEWNAME)
public class ClientInformationResponseView extends AbstractView {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(ClientInformationResponseView.class);

	public static final String VIEWNAME = "clientInformationResponseView";

	// note that this won't serialize nulls by default
	private Gson gson = new Gson();

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.view.AbstractView#renderMergedOutputModel(java.util.Map, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {

		response.setContentType(MediaType.APPLICATION_JSON_VALUE);

		RegisteredClient c = (RegisteredClient) model.get("client");
		//OAuth2AccessTokenEntity token = (OAuth2AccessTokenEntity) model.get("token");
		//String uri = (String)model.get("uri"); //request.getRequestURL() + "/" + c.getClientId();

		HttpStatus code = (HttpStatus) model.get(HttpCodeView.CODE);
		if (code == null) {
			code = HttpStatus.OK;
		}
		response.setStatus(code.value());

		JsonObject o = ClientDetailsEntityJsonProcessor.serialize(c);

		try {
			Writer out = response.getWriter();
			gson.toJson(o, out);
		} catch (JsonIOException e) {

			logger.error("JsonIOException in ClientInformationResponseView.java: ", e);

		} catch (IOException e) {

			logger.error("IOException in ClientInformationResponseView.java: ", e);

		}

	}

}
