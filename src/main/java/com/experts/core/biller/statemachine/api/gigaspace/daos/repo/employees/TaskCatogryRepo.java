package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Reminder.ReminderAppointment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.performance.TaskCatogry;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "TaskCatogry Entity")
@RepositoryRestResource(path = "TaskCatogry" , collectionResourceRel = "TaskCatogry")
@RestResource(exported = true ,path = "/service/TaskCatogry" , rel = "/service/TaskCatogry")
@Consumes("application/json")
public interface TaskCatogryRepo extends JpaRepository<TaskCatogry, Long> {
}
