package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.experinces.lookup.ExperincesLookup;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.resign.EmployeeResign;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmployeeResign Entity")
@RepositoryRestResource(path = "EmployeeResign" , collectionResourceRel = "EmployeeResign")
@RestResource(exported = true ,path = "/service/EmployeeResign" , rel = "/service/EmployeeResign")
@Consumes("application/json")
public interface EmployeeResignRepo extends JpaRepository<EmployeeResign, Long> {
}
