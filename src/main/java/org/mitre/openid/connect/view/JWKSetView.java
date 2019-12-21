
package org.mitre.openid.connect.view;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Map;

@Component(JWKSetView.VIEWNAME)
public class JWKSetView extends AbstractView {

	public static final String VIEWNAME = "jwkSet";
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(JWKSetView.class);

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {

		response.setContentType(MediaType.APPLICATION_JSON_VALUE);


		//BiMap<String, PublicKey> keyMap = (BiMap<String, PublicKey>) model.get("keys");
		Map<String, JWK> keys = (Map<String, JWK>) model.get("keys");

		JWKSet jwkSet = new JWKSet(new ArrayList<>(keys.values()));

		try {

			Writer out = response.getWriter();
			out.write(jwkSet.toString());

		} catch (IOException e) {

			logger.error("IOException in JWKSetView.java: ", e);

		}

	}

}
