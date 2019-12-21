package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.performance.TaskCatogry;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.performance.TaskIssueFaces;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "TaskIssueFaces Entity")
@RepositoryRestResource(path = "TaskIssueFaces" , collectionResourceRel = "TaskIssueFaces")
@RestResource(exported = true ,path = "/service/TaskIssueFaces" , rel = "/service/TaskIssueFaces")
@Consumes("application/json")
public interface TaskIssueFacesRepo extends JpaRepository<TaskIssueFaces, Long> {
}
