package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Aims.Aim;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.attendance.Attendance;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "Attendance Entity")
@RepositoryRestResource(path = "Attendance" , collectionResourceRel = "Attendance")
@RestResource(exported = true ,path = "/service/Attendance" , rel = "/service/Attendance")
@Consumes("application/json")
public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
}
