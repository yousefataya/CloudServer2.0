package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.crm.customer;

import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.CrmCustomerContact;
import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.customer.details.CustomerGender;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "CustomerGender Entity")
@RepositoryRestResource(path = "CustomerGender" , collectionResourceRel = "CustomerGender")
@RestResource(exported = true ,path = "/service/CustomerGender" , rel = "/service/CustomerGender")
@Consumes("application/json")
public interface CustomerGenderRepo extends JpaRepository<CustomerGender, Long> {
}
