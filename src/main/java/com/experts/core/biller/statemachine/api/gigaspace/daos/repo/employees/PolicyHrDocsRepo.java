package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.performance.JobPerformance;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.policy.lookup.PolicyHrDocs;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "PolicyHrDocs Entity")
@RepositoryRestResource(path = "PolicyHrDocs" , collectionResourceRel = "PolicyHrDocs")
@RestResource(exported = true ,path = "/service/PolicyHrDocs" , rel = "/service/PolicyHrDocs")
@Consumes("application/json")
public interface PolicyHrDocsRepo  extends JpaRepository<PolicyHrDocs, Long> {
}
