package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees.evaluations.tasks;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.evaluations.EmployeeEvaluations;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.evaluations.tasks.EmployeeEvaluationTasks;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmployeeEvaluationTasks Entity")
@RepositoryRestResource(path = "EmployeeEvaluationTasks" , collectionResourceRel = "EmployeeEvaluationTasks")
@RestResource(exported = true ,path = "/service/EmployeeEvaluationTasks" , rel = "/service/EmployeeEvaluationTasks")
@Consumes("application/json")
public interface EmployeeEvaluationTasksRepo extends JpaRepository<EmployeeEvaluationTasks, Long> {
}
