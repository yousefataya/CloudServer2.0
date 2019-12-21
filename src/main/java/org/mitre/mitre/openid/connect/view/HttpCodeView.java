
package org.mitre.mitre.openid.connect.view;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component(HttpCodeView.VIEWNAME)
public class HttpCodeView extends AbstractView {

	public static final String VIEWNAME = "httpCodeView";

	public static final String CODE = "code";

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
		HttpStatus code = (HttpStatus) model.get(CODE);
		if (code == null) {
			code = HttpStatus.OK; // default to 200
		}

		response.setStatus(code.value());

	}

}
