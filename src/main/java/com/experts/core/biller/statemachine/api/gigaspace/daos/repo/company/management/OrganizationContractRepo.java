package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company.management;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract.OragnizationContractDocs;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract.OrganizationContract;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "OrganizationContract Entity")
@RepositoryRestResource(path = "OrganizationContract" , collectionResourceRel = "OrganizationContract")
@RestResource(exported = true ,path = "/service/OrganizationContract" , rel = "/service/OrganizationContract")
@Consumes("application/json")
public interface OrganizationContractRepo  extends JpaRepository<OrganizationContract, Long> {
}
