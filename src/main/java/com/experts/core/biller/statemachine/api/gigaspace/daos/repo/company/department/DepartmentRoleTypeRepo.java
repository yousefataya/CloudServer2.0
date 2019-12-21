package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company.department;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.role.DepartmentRole;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.role.lookups.DepartmentRoleType;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "DepartmentRoleType Entity")
@RepositoryRestResource(path = "DepartmentRoleType" , collectionResourceRel = "DepartmentRoleType")
@RestResource(exported = true ,path = "/service/DepartmentRoleType" , rel = "/service/DepartmentRoleType")
@Consumes("application/json")
public interface DepartmentRoleTypeRepo extends JpaRepository<DepartmentRoleType, Long> {
}
