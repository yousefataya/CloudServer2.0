package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.crm;


import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.CustomerEmail;
import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.CustomerPhone;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "CustomerPhone Entity")
@RepositoryRestResource(path = "CustomerPhone" , collectionResourceRel = "CustomerPhone")
@RestResource(exported = true ,path = "/service/CustomerPhone" , rel = "/service/CustomerPhone")
@Consumes("application/json")
public interface CustomerPhoneRepo extends JpaRepository<CustomerPhone, Long> {
}
