package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.jira;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Reminder.ReminderAppointment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.catogry.ProjectCatogry;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "ProjectCatogry Entity")
@RepositoryRestResource(path = "ProjectCatogry" , collectionResourceRel = "ProjectCatogry")
@RestResource(exported = true ,path = "/service/ProjectCatogry" , rel = "/service/ProjectCatogry")
@Consumes("application/json")
public interface ProjectCatogryRepo extends JpaRepository<ProjectCatogry, Long> {
}
