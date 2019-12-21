package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company.department;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.lookup.DepartmentType;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.leaders.OrganizationDepartmentLeader;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "OrganizationDepartmentLeader Entity")
@RepositoryRestResource(path = "OrganizationDepartmentLeader" , collectionResourceRel = "OrganizationDepartmentLeader")
@RestResource(exported = true ,path = "/service/OrganizationDepartmentLeader" , rel = "/service/OrganizationDepartmentLeader")
@Consumes("application/json")
public interface OrganizationDepartmentLeaderRepo extends JpaRepository<OrganizationDepartmentLeader, Long> {
}
