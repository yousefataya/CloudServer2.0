package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees.leadersships;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.lookups.AbsenceCatogry;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.leaderships.EmployeeTeamMember.EmployeeTeamMember;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmployeeTeamMember Entity")
@RepositoryRestResource(path = "EmployeeTeamMember" , collectionResourceRel = "EmployeeTeamMember")
@RestResource(exported = true ,path = "/service/EmployeeTeamMember" , rel = "/service/EmployeeTeamMember")
@Consumes("application/json")
public interface EmployeeTeamMemberRepo  extends JpaRepository<EmployeeTeamMember, Long> {
}
