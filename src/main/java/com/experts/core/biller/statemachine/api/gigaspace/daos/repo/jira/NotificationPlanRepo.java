package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.jira;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.catogry.ProjectCatogry;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.notifications.NotificationPlan;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "NotificationPlan Entity")
@RepositoryRestResource(path = "NotificationPlan" , collectionResourceRel = "NotificationPlan")
@RestResource(exported = true ,path = "/service/NotificationPlan" , rel = "/service/NotificationPlan")
@Consumes("application/json")
public interface NotificationPlanRepo extends JpaRepository<NotificationPlan, Long> {
}
