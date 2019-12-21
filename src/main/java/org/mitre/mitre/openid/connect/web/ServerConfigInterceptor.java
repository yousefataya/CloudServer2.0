
package org.mitre.mitre.openid.connect.web;

import org.mitre.openid.connect.config.ConfigurationPropertiesBean;
import org.mitre.openid.connect.config.UIConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServerConfigInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private ConfigurationPropertiesBean config;

	@Autowired
	private UIConfiguration ui;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute("config", config);
		request.setAttribute("ui", ui);
		return true;
	}

}
