package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees.evaluations;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.lookups.AbsenceCatogry;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.evaluations.EmployeeEvaluations;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmployeeEvaluations Entity")
@RepositoryRestResource(path = "EmployeeEvaluations" , collectionResourceRel = "EmployeeEvaluations")
@RestResource(exported = true ,path = "/service/EmployeeEvaluations" , rel = "/service/EmployeeEvaluations")
@Consumes("application/json")
public interface EmployeeEvaluationsRepo extends JpaRepository<EmployeeEvaluations, Long> {
}
