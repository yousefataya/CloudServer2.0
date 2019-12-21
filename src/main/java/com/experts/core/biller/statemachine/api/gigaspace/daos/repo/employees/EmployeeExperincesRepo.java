package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Reminder.ReminderAppointment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.experinces.EmployeeExperinces;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmployeeExperinces Entity")
@RepositoryRestResource(path = "EmployeeExperinces" , collectionResourceRel = "EmployeeExperinces")
@RestResource(exported = true ,path = "/service/EmployeeExperinces" , rel = "/service/EmployeeExperinces")
@Consumes("application/json")
public interface EmployeeExperincesRepo extends JpaRepository<EmployeeExperinces, Long> {
}
