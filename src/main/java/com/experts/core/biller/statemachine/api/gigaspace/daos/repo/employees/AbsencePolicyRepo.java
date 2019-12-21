package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.policy.AbsencePolicy;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "Absence Entity")
@RepositoryRestResource(path = "AbsencePolicy" , collectionResourceRel = "AbsencePolicy")
@RestResource(exported = true ,path = "/service/AbsencePolicy" , rel = "/service/AbsencePolicy")
@Consumes("application/json")
public interface AbsencePolicyRepo  extends JpaRepository<AbsencePolicy, Long> {
}
