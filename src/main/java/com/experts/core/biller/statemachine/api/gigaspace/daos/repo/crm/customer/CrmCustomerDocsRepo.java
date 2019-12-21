package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.crm.customer;


import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.customer.CrmCustomerDocs;
import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.customer.details.CustomerGender;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "CrmCustomerDocs Entity")
@RepositoryRestResource(path = "CrmCustomerDocs" , collectionResourceRel = "CrmCustomerDocs")
@RestResource(exported = true ,path = "/service/CrmCustomerDocs" , rel = "/service/CrmCustomerDocs")
@Consumes("application/json")
public interface CrmCustomerDocsRepo extends JpaRepository<CrmCustomerDocs, Long> {
}
