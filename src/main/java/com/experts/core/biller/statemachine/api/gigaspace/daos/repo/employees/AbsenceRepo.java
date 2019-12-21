package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.Absence;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.AbsenceTeamNotification;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "Absence Entity")
@RepositoryRestResource(path = "Absence" , collectionResourceRel = "Absence")
@RestResource(exported = true ,path = "/service/Absence" , rel = "/service/Absence")
@Consumes("application/json")
public interface AbsenceRepo extends JpaRepository<Absence, Long> {
}
