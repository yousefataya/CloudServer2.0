package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees.leadersships;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.leaderships.EmployeeTeam;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.leaderships.EmployeeTeamMember.EmployeeTeamMember;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmployeeTeam Entity")
@RepositoryRestResource(path = "EmployeeTeam" , collectionResourceRel = "EmployeeTeam")
@RestResource(exported = true ,path = "/service/EmployeeTeam" , rel = "/service/EmployeeTeam")
@Consumes("application/json")
public interface EmployeeTeamRepo extends JpaRepository<EmployeeTeam, Long> {
}
