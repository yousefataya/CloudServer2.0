package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Reminder.ReminderAppointment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.resign.ResginDocsType;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "ResginDocsType Entity")
@RepositoryRestResource(path = "ResginDocsType" , collectionResourceRel = "ResginDocsType")
@RestResource(exported = true ,path = "/service/ResginDocsType" , rel = "/service/ResginDocsType")
@Consumes("application/json")
public interface ResginDocsTypeRepo extends JpaRepository<ResginDocsType, Long> {
}
