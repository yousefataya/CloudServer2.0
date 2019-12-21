package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.crm.stakeholder;

import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.customer.CrmCustomerContract;
import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.stakeholder.CmStakeHolderDocs;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "CmStakeHolderDocs Entity")
@RepositoryRestResource(path = "CmStakeHolderDocs" , collectionResourceRel = "CmStakeHolderDocs")
@RestResource(exported = true ,path = "/service/CmStakeHolderDocs" , rel = "/service/CmStakeHolderDocs")
@Consumes("application/json")
public interface CmStakeHolderDocsRepo extends JpaRepository<CmStakeHolderDocs, Long> {
}
