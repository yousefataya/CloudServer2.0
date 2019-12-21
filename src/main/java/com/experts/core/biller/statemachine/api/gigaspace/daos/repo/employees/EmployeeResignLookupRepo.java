package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.resign.EmployeeResignDocs;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.resign.lookup.EmployeeResignLookup;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmployeeResignLookup Entity")
@RepositoryRestResource(path = "EmployeeResignLookup" , collectionResourceRel = "EmployeeResignLookup")
@RestResource(exported = true ,path = "/service/EmployeeResignLookup" , rel = "/service/EmployeeResignLookup")
@Consumes("application/json")
public interface EmployeeResignLookupRepo extends JpaRepository<EmployeeResignLookup, Long> {
}
