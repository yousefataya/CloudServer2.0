package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company.department;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.role.DepartmentRole;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "DepartmentRole Entity")
@RepositoryRestResource(path = "DepartmentRole" , collectionResourceRel = "DepartmentRole")
@RestResource(exported = true ,path = "/service/DepartmentRole" , rel = "/service/DepartmentRole")
@Consumes("application/json")
public interface DepartmentRoleRepo extends JpaRepository<DepartmentRole, Long> {
}
