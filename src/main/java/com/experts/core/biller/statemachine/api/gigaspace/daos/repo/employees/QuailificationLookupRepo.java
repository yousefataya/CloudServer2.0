package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.qualifications.lookups.QuailificationLookup;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "QuailificationLookup Entity")
@RepositoryRestResource(path = "QuailificationLookup" , collectionResourceRel = "QuailificationLookup")
@RestResource(exported = true ,path = "/service/QuailificationLookup" , rel = "/service/QuailificationLookup")
@Consumes("application/json")
public interface QuailificationLookupRepo extends JpaRepository<QuailificationLookup, Long> {
}
