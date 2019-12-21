package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.performance.EmployeePerfomance;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.policy.EmployeePolicyHr;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmployeePolicyHr Entity")
@RepositoryRestResource(path = "EmployeePolicyHr" , collectionResourceRel = "EmployeePolicyHr")
@RestResource(exported = true ,path = "/service/EmployeePolicyHr" , rel = "/service/EmployeePolicyHr")
@Consumes("application/json")
public interface EmployeePolicyHrRepo extends JpaRepository<EmployeePolicyHr, Long> {
}
