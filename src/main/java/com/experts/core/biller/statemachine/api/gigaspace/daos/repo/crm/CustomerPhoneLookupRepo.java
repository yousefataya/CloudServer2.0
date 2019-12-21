package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.crm;


import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.lookup.CustomerMobileLookup;
import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.lookup.CustomerPhoneLookup;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "CustomerPhoneLookup Entity")
@RepositoryRestResource(path = "CustomerPhoneLookup" , collectionResourceRel = "CustomerPhoneLookup")
@RestResource(exported = true ,path = "/service/CustomerPhoneLookup" , rel = "/service/CustomerPhoneLookup")
@Consumes("application/json")
public interface CustomerPhoneLookupRepo extends JpaRepository<CustomerPhoneLookup, Long> {
}
