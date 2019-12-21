package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees.contract;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contract.EmployeeContract;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contract.lookups.EmpoyeeContractLookup;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmployeeContract Entity")
@RepositoryRestResource(path = "EmpoyeeContractLooku" , collectionResourceRel = "EmpoyeeContractLooku")
@RestResource(exported = true ,path = "/service/EmpoyeeContractLooku" , rel = "/service/EmpoyeeContractLooku")
@Consumes("application/json")
public interface  EmpoyeeContractLookupRepo extends JpaRepository<EmpoyeeContractLookup, Long> {
}
