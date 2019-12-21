package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company.management.lookup;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract.lookup.ContractDocsType;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract.lookup.ContractType;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "ContractType Entity")
@RepositoryRestResource(path = "ContractType" , collectionResourceRel = "ContractType")
@RestResource(exported = true ,path = "/service/ContractType" , rel = "/service/ContractType")
@Consumes("application/json")
public interface ContractTypeRepo extends JpaRepository<ContractType, Long> {
}
