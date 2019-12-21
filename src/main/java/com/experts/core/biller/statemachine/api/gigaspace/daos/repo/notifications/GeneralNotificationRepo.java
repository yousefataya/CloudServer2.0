package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.notifications;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.tasks.lookups.TaskType;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.notifications.GeneralNotification;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "GeneralNotification Entity")
@RepositoryRestResource(path = "GeneralNotification" , collectionResourceRel = "GeneralNotification")
@RestResource(exported = true ,path = "/service/GeneralNotification" , rel = "/service/GeneralNotification")
@Consumes("application/json")
public interface GeneralNotificationRepo extends JpaRepository<GeneralNotification, Long> {
}
