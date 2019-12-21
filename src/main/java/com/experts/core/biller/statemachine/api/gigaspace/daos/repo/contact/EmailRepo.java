package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.contact;

import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.customer.CrmCustomerContract;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.Email;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "Email Entity")
@RepositoryRestResource(path = "Email" , collectionResourceRel = "Email")
@RestResource(exported = true ,path = "/service/Email" , rel = "/service/Email")
@Consumes("application/json")
public interface EmailRepo extends JpaRepository<Email, Long> {
}
