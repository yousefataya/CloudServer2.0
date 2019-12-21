package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.crm.stakeholder.lookup;


import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.stakeholder.CmStakeHolderDocs;
import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.stakeholder.lookups.StakeHolderType;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "CmStakeHolderDocs Entity")
@RepositoryRestResource(path = "StakeHolderType" , collectionResourceRel = "StakeHolderType")
@RestResource(exported = true ,path = "/service/StakeHolderType" , rel = "/service/StakeHolderType")
@Consumes("application/json")
public interface StakeHolderTypeRepo extends JpaRepository<StakeHolderType, Long> {
}
