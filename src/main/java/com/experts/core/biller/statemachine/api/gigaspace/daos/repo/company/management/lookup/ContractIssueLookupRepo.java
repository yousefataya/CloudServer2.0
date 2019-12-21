package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company.management.lookup;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract.lookup.ContractDocsType;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contractissuer.lookup.ContractIssueLookup;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "ContractIssueLookup Entity")
@RepositoryRestResource(path = "ContractIssueLookup" , collectionResourceRel = "ContractIssueLookup")
@RestResource(exported = true ,path = "/service/ContractIssueLookup" , rel = "/service/ContractIssueLookup")
@Consumes("application/json")
public interface ContractIssueLookupRepo extends JpaRepository<ContractIssueLookup, Long> {
}
