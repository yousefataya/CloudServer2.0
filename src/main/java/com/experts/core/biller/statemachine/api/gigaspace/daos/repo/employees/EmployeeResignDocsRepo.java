package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.policy.EmployeePolicyHr;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.resign.EmployeeResignDocs;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmployeeResignDocs Entity")
@RepositoryRestResource(path = "EmployeeResignDocs" , collectionResourceRel = "EmployeeResignDocs")
@RestResource(exported = true ,path = "/service/EmployeeResignDocs" , rel = "/service/EmployeeResignDocs")
@Consumes("application/json")
public interface EmployeeResignDocsRepo extends JpaRepository<EmployeeResignDocs, Long> {
}
