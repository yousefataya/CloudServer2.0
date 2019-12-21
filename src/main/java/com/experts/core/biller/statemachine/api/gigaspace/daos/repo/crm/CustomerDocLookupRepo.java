package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.crm;

import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.customer.lookup.CustomerDocLookup;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import javax.ws.rs.Consumes;

@Api(tags = "CustomerDocLookup Entity")
@RepositoryRestResource(path = "CustomerDocLookup" , collectionResourceRel = "CustomerDocLookup")
@RestResource(exported = true ,path = "/service/CustomerDocLookup" , rel = "/service/CustomerDocLookup")
@Consumes("application/json")
public interface CustomerDocLookupRepo  extends JpaRepository<CustomerDocLookup, Long> {
}
