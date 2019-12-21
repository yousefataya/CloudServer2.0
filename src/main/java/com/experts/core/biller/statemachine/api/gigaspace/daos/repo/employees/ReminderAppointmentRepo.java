package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.lookups.AbsenceCatogry;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Reminder.ReminderAppointment;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "ReminderAppointment Entity")
@RepositoryRestResource(path = "ReminderAppointment" , collectionResourceRel = "ReminderAppointment")
@RestResource(exported = true ,path = "/service/ReminderAppointment" , rel = "/service/ReminderAppointment")
@Consumes("application/json")
public interface ReminderAppointmentRepo extends JpaRepository<ReminderAppointment, Long> {
}
