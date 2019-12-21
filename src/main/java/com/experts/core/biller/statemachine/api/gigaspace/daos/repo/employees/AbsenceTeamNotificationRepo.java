package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.CustomerPhone;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.AbsenceTeamNotification;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "AbsenceTeamNotification Entity")
@RepositoryRestResource(path = "AbsenceTeamNotification" , collectionResourceRel = "AbsenceTeamNotification")
@RestResource(exported = true ,path = "/service/AccountDetails" , rel = "/service/AbsenceTeamNotification")
@Consumes("application/json")
public interface AbsenceTeamNotificationRepo extends JpaRepository<AbsenceTeamNotification, Long> {
}
