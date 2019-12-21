package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.crm.customer;


import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.customer.CustomerDetails;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "CrmCustomerContract Entity")
@RepositoryRestResource(path = "CrmCustomerContract" , collectionResourceRel = "CrmCustomerContract")
@RestResource(exported = true ,path = "/service/CrmCustomerContract" , rel = "/service/CrmCustomerContract")
@Consumes("application/json")
public interface CustomerDetailsRepo  extends JpaRepository<CustomerDetails, Long> {
}
