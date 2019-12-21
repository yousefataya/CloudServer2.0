package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company.management;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.branch.CompanyBranchInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract.ContractMainPartenerDocs;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "ContractMainPartenerDocs Entity")
@RepositoryRestResource(path = "ContractMainPartenerDocs" , collectionResourceRel = "ContractMainPartenerDocs")
@RestResource(exported = true ,path = "/service/ContractMainPartenerDocs" , rel = "/service/ContractMainPartenerDocs")
@Consumes("application/json")
public interface ContractMainPartenerDocsRepo extends JpaRepository<ContractMainPartenerDocs, Long> {
}
