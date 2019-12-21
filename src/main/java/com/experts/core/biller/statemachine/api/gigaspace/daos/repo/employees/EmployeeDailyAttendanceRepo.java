package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Reminder.ReminderAppointment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.attendance.EmployeeDailyAttendance;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "Attendance Entity")
@RepositoryRestResource(path = "EmployeeDailyAttendance" , collectionResourceRel = "EmployeeDailyAttendance")
@RestResource(exported = true ,path = "/service/EmployeeDailyAttendance" , rel = "/service/EmployeeDailyAttendance")
@Consumes("application/json")
public interface EmployeeDailyAttendanceRepo extends JpaRepository<EmployeeDailyAttendance, Long> {
}
