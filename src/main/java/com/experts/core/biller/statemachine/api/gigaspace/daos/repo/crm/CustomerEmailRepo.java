package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.crm;


import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.CustomerEmail;
import com.experts.core.biller.statemachine.api.model.domain.jpa.settlement.AccountDetails;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "CustomerEmail Entity")
@RepositoryRestResource(path = "CustomerEmail" , collectionResourceRel = "CustomerEmail")
@RestResource(exported = true ,path = "/service/CustomerEmail" , rel = "/service/CustomerEmail")
@Consumes("application/json")
public interface CustomerEmailRepo extends JpaRepository<CustomerEmail, Long> {
}
