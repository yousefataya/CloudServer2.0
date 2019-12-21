package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.contact;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.Email;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.Mobile;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "Mobile Entity")
@RepositoryRestResource(path = "Mobile" , collectionResourceRel = "Mobile")
@RestResource(exported = true ,path = "/service/Mobile" , rel = "/service/Mobile")
@Consumes("application/json")
public interface MobileRepo extends JpaRepository<Mobile, Long> {
}
