
package org.mitre.mitre.openid.connect.web;

import com.nimbusds.jose.jwk.JWK;
import org.mitre.jwt.signer.service.JWTSigningAndValidationService;
import org.mitre.openid.connect.view.JWKSetView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class JWKSetPublishingEndpoint {

	public static final String URL = "jwk";

	@Autowired
	private JWTSigningAndValidationService jwtService;

	@RequestMapping(value = "/" + URL, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getJwk(Model m) {

		// map from key id to key
		Map<String, JWK> keys = jwtService.getAllPublicKeys();

		// TODO: check if keys are empty, return a 404 here or just an empty list?

		m.addAttribute("keys", keys);

		return JWKSetView.VIEWNAME;
	}


	public JWTSigningAndValidationService getJwtService() {
		return jwtService;
	}


	public void setJwtService(JWTSigningAndValidationService jwtService) {
		this.jwtService = jwtService;
	}

}
