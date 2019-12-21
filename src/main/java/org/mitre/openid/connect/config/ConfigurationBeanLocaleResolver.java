
package org.mitre.openid.connect.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.TimeZoneAwareLocaleContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.i18n.AbstractLocaleContextResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.TimeZone;


@Component
public class ConfigurationBeanLocaleResolver extends AbstractLocaleContextResolver {

	@Autowired
	private ConfigurationPropertiesBean config;

	@Override
	protected Locale getDefaultLocale() {
		if (config.getLocale() != null) {
			return config.getLocale();
		} else {
			return super.getDefaultLocale();
		}
	}

	@Override
	public LocaleContext resolveLocaleContext(HttpServletRequest request) {
		return new TimeZoneAwareLocaleContext() {
			@Override
			public Locale getLocale() {
				return getDefaultLocale();
			}
			@Override
			public TimeZone getTimeZone() {
				return getDefaultTimeZone();
			}
		};
	}

	@Override
	public void setLocaleContext(HttpServletRequest request, HttpServletResponse response, LocaleContext localeContext) {
		throw new UnsupportedOperationException("Cannot change fixed locale - use a different locale resolution strategy");
	}

}
