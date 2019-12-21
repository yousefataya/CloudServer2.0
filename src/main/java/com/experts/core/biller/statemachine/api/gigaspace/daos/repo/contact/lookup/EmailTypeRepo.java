package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.contact.lookup;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.Email;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.lookups.EmailType;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmailType Entity")
@RepositoryRestResource(path = "EmailType" , collectionResourceRel = "EmailType")
@RestResource(exported = true ,path = "/service/EmailType" , rel = "/service/EmailType")
@Consumes("application/json")
public interface EmailTypeRepo extends JpaRepository<EmailType, Long> {
}
