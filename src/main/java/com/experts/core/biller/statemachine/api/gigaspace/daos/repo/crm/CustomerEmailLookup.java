package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.crm;


import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.CustomerPhone;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "CustomerEmailLookup Entity")
@RepositoryRestResource(path = "CustomerEmailLookup" , collectionResourceRel = "CustomerEmailLookup")
@RestResource(exported = true ,path = "/service/CustomerEmailLookup" , rel = "/service/CustomerEmailLookup")
@Consumes("application/json")
public interface CustomerEmailLookup extends JpaRepository<com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.lookup.CustomerEmailLookup, Long> {
}
