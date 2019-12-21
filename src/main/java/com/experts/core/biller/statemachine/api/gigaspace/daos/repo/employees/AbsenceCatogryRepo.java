package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.lookups.AbsenceCatogry;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.policy.AbsencePolicy;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "AbsenceCatogry Entity")
@RepositoryRestResource(path = "AbsenceCatogry" , collectionResourceRel = "AbsenceCatogry")
@RestResource(exported = true ,path = "/service/AbsenceCatogry" , rel = "/service/AbsenceCatogry")
@Consumes("application/json")
public interface AbsenceCatogryRepo extends JpaRepository<AbsenceCatogry, Long> {
}
