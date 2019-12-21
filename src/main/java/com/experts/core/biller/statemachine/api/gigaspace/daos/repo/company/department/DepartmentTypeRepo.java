package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company.department;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.lookup.DepartmentType;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.role.lookups.DepartmentRoleType;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "DepartmentType Entity")
@RepositoryRestResource(path = "DepartmentType" , collectionResourceRel = "DepartmentType")
@RestResource(exported = true ,path = "/service/DepartmentType" , rel = "/service/DepartmentType")
@Consumes("application/json")
public interface DepartmentTypeRepo extends JpaRepository<DepartmentType, Long> {
}
