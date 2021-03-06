
package org.mitre.mitre.openid.connect.web;

import org.mitre.mitre.openid.connect.view.HttpCodeView;
import org.mitre.mitre.openid.connect.view.JsonApprovedSiteView;
import org.mitre.mitre.openid.connect.view.JsonEntityView;
import org.mitre.mitre.openid.connect.view.JsonErrorView;
import org.mitre.openid.connect.model.ApprovedSite;
import org.mitre.openid.connect.service.ApprovedSiteService;
/*import org.mitre.openid.connect.view.HttpCodeView;
import org.mitre.openid.connect.view.JsonApprovedSiteView;
import org.mitre.openid.connect.view.JsonEntityView;
import org.mitre.openid.connect.view.JsonErrorView;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Collection;

@Controller
@RequestMapping("/" + ApprovedSiteAPI.URL)
@PreAuthorize("hasRole('ROLE_USER')")
public class ApprovedSiteAPI {

	public static final String URL = RootController.API_URL + "/approved";

	@Autowired
	private ApprovedSiteService approvedSiteService;


	private static final Logger logger = LoggerFactory.getLogger(ApprovedSiteAPI.class);

	/**
	 * Get a list of all of this user's approved sites
	 * @param m
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAllApprovedSites(ModelMap m, Principal p) {

		Collection<ApprovedSite> all = approvedSiteService.getByUserId(p.getName());

		m.put(JsonEntityView.ENTITY, all);

		return JsonApprovedSiteView.VIEWNAME;
	}

	/**
	 * Delete an approved site
	 *
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public String deleteApprovedSite(@PathVariable("id") Long id, ModelMap m, Principal p) {
		ApprovedSite approvedSite = approvedSiteService.getById(id);

		if (approvedSite == null) {
			logger.error("deleteApprovedSite failed; no approved site found for id: " + id);
			m.put(HttpCodeView.CODE, HttpStatus.NOT_FOUND);
			m.put(JsonErrorView.ERROR_MESSAGE, "Could not delete approved site. The requested approved site with id: " + id + " could not be found.");
			return JsonErrorView.VIEWNAME;
		} else if (!approvedSite.getUserId().equals(p.getName())) {
			logger.error("deleteApprovedSite failed; principal "
					+ p.getName() + " does not own approved site" + id);
			m.put(HttpCodeView.CODE, HttpStatus.FORBIDDEN);
			m.put(JsonErrorView.ERROR_MESSAGE, "You do not have permission to delete this approved site. The approved site decision will not be deleted.");
			return JsonErrorView.VIEWNAME;
		} else {
			m.put(HttpCodeView.CODE, HttpStatus.OK);
			approvedSiteService.remove(approvedSite);
		}

		return HttpCodeView.VIEWNAME;
	}

	/**
	 * Get a single approved site
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getApprovedSite(@PathVariable("id") Long id, ModelMap m, Principal p) {
		ApprovedSite approvedSite = approvedSiteService.getById(id);
		if (approvedSite == null) {
			logger.error("getApprovedSite failed; no approved site found for id: " + id);
			m.put(HttpCodeView.CODE, HttpStatus.NOT_FOUND);
			m.put(JsonErrorView.ERROR_MESSAGE, "The requested approved site with id: " + id + " could not be found.");
			return JsonErrorView.VIEWNAME;
		} else if (!approvedSite.getUserId().equals(p.getName())) {
			logger.error("getApprovedSite failed; principal "
					+ p.getName() + " does not own approved site" + id);
			m.put(HttpCodeView.CODE, HttpStatus.FORBIDDEN);
			m.put(JsonErrorView.ERROR_MESSAGE, "You do not have permission to view this approved site.");
			return JsonErrorView.VIEWNAME;
		} else {
			m.put(JsonEntityView.ENTITY, approvedSite);
			return JsonApprovedSiteView.VIEWNAME;
		}

	}

}
