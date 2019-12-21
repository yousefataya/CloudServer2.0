package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.contact.lookup;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.lookups.PhoneType;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.lookups.SkypeType;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "SkypeType Entity")
@RepositoryRestResource(path = "SkypeType" , collectionResourceRel = "SkypeType")
@RestResource(exported = true ,path = "/service/SkypeType" , rel = "/service/SkypeType")
@Consumes("application/json")
public interface SkypeTypeRepo extends JpaRepository<SkypeType, Long> {
}
