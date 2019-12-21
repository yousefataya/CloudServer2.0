package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.jira;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.tasks.Tasks;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.tasks.lookups.TaskType;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "Tasks Entity")
@RepositoryRestResource(path = "TaskType" , collectionResourceRel = "TaskType")
@RestResource(exported = true ,path = "/service/TaskType" , rel = "/service/TaskType")
@Consumes("application/json")
public interface TaskTypeRepo extends JpaRepository<TaskType, Long> {
}
