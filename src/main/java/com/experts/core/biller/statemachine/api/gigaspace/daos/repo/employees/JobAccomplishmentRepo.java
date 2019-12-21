package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.experinces.lookup.ExperincesLookup;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.performance.JobAccomplishment;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "JobAccomplishment Entity")
@RepositoryRestResource(path = "JobAccomplishment" , collectionResourceRel = "JobAccomplishment")
@RestResource(exported = true ,path = "/service/JobAccomplishment" , rel = "/service/JobAccomplishment")
@Consumes("application/json")
public interface JobAccomplishmentRepo extends JpaRepository<JobAccomplishment, Long> {
}
