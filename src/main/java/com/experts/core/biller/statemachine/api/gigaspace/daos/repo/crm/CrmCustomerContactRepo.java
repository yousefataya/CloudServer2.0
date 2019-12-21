package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.crm;

import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.CrmCustomerContact;
import com.experts.core.biller.statemachine.api.model.domain.jpa.settlement.AccountDetails;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "AccountDetails Entity")
@RepositoryRestResource(path = "CrmCustomerContact" , collectionResourceRel = "CrmCustomerContact")
@RestResource(exported = true ,path = "/service/CrmCustomerContact" , rel = "/service/CrmCustomerContact")
@Consumes("application/json")
public interface CrmCustomerContactRepo extends JpaRepository<CrmCustomerContact, Long> {

}
