package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.leave.EmployeeLeaveManage;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.leave.lookup.EmployeeLeaveLookup;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmployeeExperinces Entity")
@RepositoryRestResource(path = "EmployeeHolidayLookup" , collectionResourceRel = "EmployeeHolidayLookup")
@RestResource(exported = true ,path = "/service/EmployeeHolidayLookup" , rel = "/service/EmployeeHolidayLookup")
@Consumes("application/json")
public interface EmployeeLeaveLookupRepo extends JpaRepository<EmployeeLeaveLookup, Long> {
}
