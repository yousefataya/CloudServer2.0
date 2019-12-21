package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.performance.JobAccomplishment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.performance.JobPerformance;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "JobPerformance Entity")
@RepositoryRestResource(path = "JobPerformance" , collectionResourceRel = "JobPerformance")
@RestResource(exported = true ,path = "/service/JobPerformance" , rel = "/service/JobPerformance")
@Consumes("application/json")
public interface JobPerformanceRepo extends JpaRepository<JobPerformance, Long> {
}
