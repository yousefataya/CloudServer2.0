package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.experinces.lookup.ExperincesLookup;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.holiday.EmployeeHoliday;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmployeeHoliday Entity")
@RepositoryRestResource(path = "EmployeeHoliday" , collectionResourceRel = "EmployeeHoliday")
@RestResource(exported = true ,path = "/service/EmployeeHoliday" , rel = "/service/EmployeeHoliday")
@Consumes("application/json")
public interface EmployeeHolidayRepo extends JpaRepository<EmployeeHoliday, Long> {
}
