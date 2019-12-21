package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.crm.stakeholder;


import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.stakeholder.StakeHolderMainInfo;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "CmStakeHolderDocs Entity")
@RepositoryRestResource(path = "StakeHolderMainInfo" , collectionResourceRel = "StakeHolderMainInfo")
@RestResource(exported = true ,path = "/service/StakeHolderMainInfo" , rel = "/service/StakeHolderMainInfo")
@Consumes("application/json")
public interface StakeHolderMainInfoRepo extends JpaRepository<StakeHolderMainInfo, Long> {
}
