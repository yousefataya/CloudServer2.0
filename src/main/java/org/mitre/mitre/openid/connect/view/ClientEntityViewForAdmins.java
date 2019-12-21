
package org.mitre.mitre.openid.connect.view;

import com.google.common.collect.ImmutableSet;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.Set;

@Component(ClientEntityViewForAdmins.VIEWNAME)
public class ClientEntityViewForAdmins extends AbstractClientEntityView {

	public static final String VIEWNAME = "clientEntityViewAdmins";
	private Set<String> blacklistedFields = ImmutableSet.of("additionalInformation");

	@Override
	protected ExclusionStrategy getExclusionStrategy() {
		return new ExclusionStrategy() {

			@Override
			public boolean shouldSkipField(FieldAttributes f) {
				if (blacklistedFields.contains(f.getName())) {
					return true;
				} else {
					return false;
				}
			}

			@Override
			public boolean shouldSkipClass(Class<?> clazz) {
				// skip the JPA binding wrapper
				if (clazz.equals(BeanPropertyBindingResult.class)) {
					return true;
				}
				return false;
			}

		};
	}
}
