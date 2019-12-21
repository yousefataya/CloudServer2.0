package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company.department;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.lookup.DepartmentType;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.leaders.lookup.EmployeeLeaderRole;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmployeeLeaderRole Entity")
@RepositoryRestResource(path = "EmployeeLeaderRole" , collectionResourceRel = "EmployeeLeaderRole")
@RestResource(exported = true ,path = "/service/EmployeeLeaderRole" , rel = "/service/EmployeeLeaderRole")
@Consumes("application/json")
public interface EmployeeLeaderRoleRepo extends JpaRepository<EmployeeLeaderRole, Long> {
}
