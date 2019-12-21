package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.contact.lookup;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.lookups.EmailType;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.lookups.MobileType;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "MobileType Entity")
@RepositoryRestResource(path = "MobileType" , collectionResourceRel = "MobileType")
@RestResource(exported = true ,path = "/service/MobileType" , rel = "/service/MobileType")
@Consumes("application/json")
public interface MobileTypeRepo extends JpaRepository<MobileType, Long> {
}
