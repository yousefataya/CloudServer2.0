
package org.mitre.mitre.openid.connect.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.datetime.DateFormatter;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public abstract class MITREidDataServiceSupport {
	private final DateFormatter dateFormatter;
	
	private static final Logger logger = LoggerFactory.getLogger(MITREidDataServiceSupport.class);

	public MITREidDataServiceSupport() {
		dateFormatter = new DateFormatter();
		dateFormatter.setIso(ISO.DATE_TIME);
	}

	protected Date utcToDate(String value) {
		if (value == null) {
			return null;
		}
		try {
			return dateFormatter.parse(value, Locale.ENGLISH);
		} catch (ParseException ex) {
			logger.error("Unable to parse datetime {}", value, ex);
		}
		return null;
	}

	protected String toUTCString(Date value) {
		if (value == null) {
			return null;
		}
		return dateFormatter.print(value, Locale.ENGLISH);
	}

}
