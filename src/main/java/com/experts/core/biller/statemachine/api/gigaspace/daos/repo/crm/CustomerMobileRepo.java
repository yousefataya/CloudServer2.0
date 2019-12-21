package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.crm;


import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.CustomerMobile;
import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.CustomerPhone;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "CustomerMobile Entity")
@RepositoryRestResource(path = "CustomerMobile" , collectionResourceRel = "CustomerMobile")
@RestResource(exported = true ,path = "/service/CustomerMobile" , rel = "/service/CustomerMobile")
@Consumes("application/json")
public interface CustomerMobileRepo extends JpaRepository<CustomerMobile, Long> {
}
