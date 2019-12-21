package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees.contract;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.policy.AbsencePolicy;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contract.EmployeeContract;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmployeeContract Entity")
@RepositoryRestResource(path = "EmployeeContract" , collectionResourceRel = "EmployeeContract")
@RestResource(exported = true ,path = "/service/EmployeeContract" , rel = "/service/EmployeeContract")
@Consumes("application/json")
public interface EmployeeContractRepo extends JpaRepository<EmployeeContract, Long> {
}
