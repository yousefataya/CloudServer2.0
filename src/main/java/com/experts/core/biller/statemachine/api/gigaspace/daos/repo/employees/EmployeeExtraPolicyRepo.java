package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.experinces.EmployeeExperinces;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.policy.EmployeeExtraPolicy;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmployeeExtraPolicy Entity")
@RepositoryRestResource(path = "EmployeeExtraPolicy" , collectionResourceRel = "EmployeeExtraPolicy")
@RestResource(exported = true ,path = "/service/EmployeeExtraPolicy" , rel = "/service/EmployeeExtraPolicy")
@Consumes("application/json")
public interface EmployeeExtraPolicyRepo extends JpaRepository<EmployeeExtraPolicy, Long> {
}
