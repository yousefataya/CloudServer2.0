package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Reminder.ReminderAppointment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.experinces.lookup.ExperincesLookup;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "ExperincesLookup Entity")
@RepositoryRestResource(path = "ExperincesLookup" , collectionResourceRel = "ExperincesLookup")
@RestResource(exported = true ,path = "/service/ExperincesLookup" , rel = "/service/ExperincesLookup")
@Consumes("application/json")
public interface ExperincesLookupRepo extends JpaRepository<ExperincesLookup, Long> {
}
