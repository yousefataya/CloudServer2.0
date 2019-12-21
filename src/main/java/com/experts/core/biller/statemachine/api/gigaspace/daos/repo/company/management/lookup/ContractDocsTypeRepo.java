package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company.management.lookup;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract.ContractMainPartenerDocs;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract.lookup.ContractDocsType;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "ContractDocsType Entity")
@RepositoryRestResource(path = "ContractDocsType" , collectionResourceRel = "ContractDocsType")
@RestResource(exported = true ,path = "/service/ContractDocsType" , rel = "/service/ContractDocsType")
@Consumes("application/json")
public interface ContractDocsTypeRepo extends JpaRepository<ContractDocsType, Long> {
}
