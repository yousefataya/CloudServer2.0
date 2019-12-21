package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.contact.lookup;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.lookups.EmailType;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.lookups.PhoneType;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "PhoneType Entity")
@RepositoryRestResource(path = "PhoneType" , collectionResourceRel = "PhoneType")
@RestResource(exported = true ,path = "/service/PhoneType" , rel = "/service/PhoneType")
@Consumes("application/json")
public interface PhoneTypeRepo  extends JpaRepository<PhoneType, Long> {
}
