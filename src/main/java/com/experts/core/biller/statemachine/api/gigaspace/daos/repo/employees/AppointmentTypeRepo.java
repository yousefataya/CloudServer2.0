package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.attendance.Attendance;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.lookups.AppointmentType;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "AppointmentType Entity")
@RepositoryRestResource(path = "AppointmentType" , collectionResourceRel = "AppointmentType")
@RestResource(exported = true ,path = "/service/AppointmentType" , rel = "/service/AppointmentType")
@Consumes("application/json")
public interface AppointmentTypeRepo extends JpaRepository<AppointmentType, Long> {
}
