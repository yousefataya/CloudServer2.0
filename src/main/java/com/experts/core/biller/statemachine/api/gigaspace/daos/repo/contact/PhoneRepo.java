package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.contact;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.Mobile;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.Phone;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "Phone Entity")
@RepositoryRestResource(path = "Phone" , collectionResourceRel = "Phone")
@RestResource(exported = true ,path = "/service/Phone" , rel = "/service/Phone")
@Consumes("application/json")
public interface PhoneRepo extends JpaRepository<Phone, Long> {
}
