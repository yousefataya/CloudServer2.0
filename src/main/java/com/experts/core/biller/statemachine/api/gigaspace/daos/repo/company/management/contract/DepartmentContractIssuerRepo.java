package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company.management.contract;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract.ContractMainPartenerDocs;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contractissuer.DepartmentContractIssuer;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "DepartmentContractIssuer Entity")
@RepositoryRestResource(path = "DepartmentContractIssuer" , collectionResourceRel = "DepartmentContractIssuer")
@RestResource(exported = true ,path = "/service/DepartmentContractIssuer" , rel = "/service/DepartmentContractIssuer")
@Consumes("application/json")
public interface DepartmentContractIssuerRepo extends JpaRepository<DepartmentContractIssuer, Long> {
}
