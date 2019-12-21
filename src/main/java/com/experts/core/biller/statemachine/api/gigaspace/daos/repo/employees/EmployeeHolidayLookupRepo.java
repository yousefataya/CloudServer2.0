package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.experinces.EmployeeExperinces;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.holiday.lookup.EmployeeHolidayLookup;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmployeeExperinces Entity")
@RepositoryRestResource(path = "EmployeeHolidayLookup" , collectionResourceRel = "EmployeeHolidayLookup")
@RestResource(exported = true ,path = "/service/EmployeeHolidayLookup" , rel = "/service/EmployeeHolidayLookup")
@Consumes("application/json")
public interface EmployeeHolidayLookupRepo extends JpaRepository<EmployeeHolidayLookup, Long> {
}
