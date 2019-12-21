package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Aims.Aim;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Appointment;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "AlertType Entity")
@RepositoryRestResource(path = "Appointment" , collectionResourceRel = "Appointment")
@RestResource(exported = true ,path = "/service/Appointment" , rel = "/service/Appointment")
@Consumes("application/json")
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
}
