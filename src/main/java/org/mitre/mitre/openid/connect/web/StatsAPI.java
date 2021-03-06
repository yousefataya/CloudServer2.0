
package org.mitre.mitre.openid.connect.web;

import org.mitre.mitre.openid.connect.view.JsonEntityView;
import org.mitre.openid.connect.model.ClientStat;
import org.mitre.openid.connect.service.StatsService;
/*import org.mitre.openid.connect.view.JsonEntityView;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/" + StatsAPI.URL)
public class StatsAPI {

	public static final String URL = RootController.API_URL + "/stats";

	// Logger for this class
	private static final Logger logger = LoggerFactory.getLogger(StatsAPI.class);

	@Autowired
	private StatsService statsService;

	@RequestMapping(value = "summary", produces = MediaType.APPLICATION_JSON_VALUE)
	public String statsSummary(ModelMap m) {

		Map<String, Integer> e = statsService.getSummaryStats();

		m.put(JsonEntityView.ENTITY, e);

		return JsonEntityView.VIEWNAME;

	}

	//	@PreAuthorize("hasRole('ROLE_USER')")
	//	@RequestMapping(value = "byclientid", produces = MediaType.APPLICATION_JSON_VALUE)
	//	public String statsByClient(ModelMap m) {
	//		Map<Long, Integer> e = statsService.getByClientId();
	//
	//		m.put(JsonEntityView.ENTITY, e);
	//
	//		return JsonEntityView.VIEWNAME;
	//	}
	//
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "byclientid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String statsByClientId(@PathVariable("id") String clientId, ModelMap m) {
		ClientStat e = statsService.getCountForClientId(clientId);

		m.put(JsonEntityView.ENTITY, e);

		return JsonEntityView.VIEWNAME;
	}

}
