package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.branch.CompanyBranchInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.branch.lookup.CompanyBranchLookup;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "CompanyBranchLookup Entity")
@RepositoryRestResource(path = "CompanyBranchLookup" , collectionResourceRel = "CompanyBranchLookup")
@RestResource(exported = true ,path = "/service/CompanyBranchLookup" , rel = "/service/CompanyBranchLookup")
@Consumes("application/json")
public interface CompanyBranchLookupRepo extends JpaRepository<CompanyBranchLookup, Long> {
}
