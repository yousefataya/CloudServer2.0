package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.leave.EmployeeLeaveManage;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.performance.EmployeePerfomance;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmployeePerfomance Entity")
@RepositoryRestResource(path = "EmployeePerfomance" , collectionResourceRel = "EmployeePerfomance")
@RestResource(exported = true ,path = "/service/EmployeePerfomance" , rel = "/service/EmployeePerfomance")
@Consumes("application/json")
public interface EmployeePerfomanceRepo extends JpaRepository<EmployeePerfomance, Long> {
}
