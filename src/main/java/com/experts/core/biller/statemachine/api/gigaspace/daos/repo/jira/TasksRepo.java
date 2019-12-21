package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.jira;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.stage.ProjectStage;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.tasks.Tasks;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "Tasks Entity")
@RepositoryRestResource(path = "Tasks" , collectionResourceRel = "Tasks")
@RestResource(exported = true ,path = "/service/Tasks" , rel = "/service/Tasks")
@Consumes("application/json")
public interface TasksRepo extends JpaRepository<Tasks, Long> {
}
