package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.contact;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.Phone;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.Skype;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "Skype Entity")
@RepositoryRestResource(path = "Skype" , collectionResourceRel = "Skype")
@RestResource(exported = true ,path = "/service/Skype" , rel = "/service/Skype")
@Consumes("application/json")
public interface SkypeRepo extends JpaRepository<Skype, Long> {
}
