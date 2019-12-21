package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.policy.EmployeePolicyHr;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.qualifications.EmployeeQuailification;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmployeeQuailification Entity")
@RepositoryRestResource(path = "EmployeeQuailification" , collectionResourceRel = "EmployeeQuailification")
@RestResource(exported = true ,path = "/service/EmployeeQuailification" , rel = "/service/EmployeeQuailification")
@Consumes("application/json")
public interface EmployeeQuailificationRepo extends JpaRepository<EmployeeQuailification, Long> {
}
