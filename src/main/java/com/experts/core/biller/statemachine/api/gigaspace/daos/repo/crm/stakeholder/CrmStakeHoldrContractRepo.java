package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.crm.stakeholder;


import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.stakeholder.CmStakeHolderDocs;
import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.stakeholder.CrmStakeHoldrContract;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "CmStakeHolderDocs Entity")
@RepositoryRestResource(path = "CrmStakeHoldrContract" , collectionResourceRel = "CrmStakeHoldrContract")
@RestResource(exported = true ,path = "/service/CrmStakeHoldrContract" , rel = "/service/CrmStakeHoldrContract")
@Consumes("application/json")
public interface CrmStakeHoldrContractRepo extends JpaRepository<CrmStakeHoldrContract, Long> {
}
