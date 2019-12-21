
package org.mitre.mitre.oauth2.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
public class OAuth2ExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(OAuth2ExceptionHandler.class);

	@Autowired
	private WebResponseExceptionTranslator providerExceptionHandler;

	@ExceptionHandler(OAuth2Exception.class)
	public ResponseEntity<OAuth2Exception> handleException(Exception e) throws Exception {
		logger.info("Handling error: " + e.getClass().getSimpleName() + ", " + e.getMessage());
		return providerExceptionHandler.translate(e);
	}

}
