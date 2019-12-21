package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.lookups.AlertType;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Aims.Aim;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "AlertType Entity")
@RepositoryRestResource(path = "AlertType" , collectionResourceRel = "AlertType")
@RestResource(exported = true ,path = "/service/AlertType" , rel = "/service/AlertType")
@Consumes("application/json")
public interface AimRepo extends JpaRepository<Aim, Long> {
}
