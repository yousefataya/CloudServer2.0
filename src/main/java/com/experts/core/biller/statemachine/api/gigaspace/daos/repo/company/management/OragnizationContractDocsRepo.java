package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company.management;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract.ContractMainPartenerDocs;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract.OragnizationContractDocs;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "OragnizationContractDocs Entity")
@RepositoryRestResource(path = "OragnizationContractDocs" , collectionResourceRel = "OragnizationContractDocs")
@RestResource(exported = true ,path = "/service/OragnizationContractDocs" , rel = "/service/OragnizationContractDocs")
@Consumes("application/json")
public interface OragnizationContractDocsRepo  extends JpaRepository<OragnizationContractDocs, Long> {
}
