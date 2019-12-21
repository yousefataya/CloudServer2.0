package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contract.EmployeeContract;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.branch.CompanyBranchInfo;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "CompanyBranchInfo Entity")
@RepositoryRestResource(path = "CompanyBranchInfo" , collectionResourceRel = "CompanyBranchInfo")
@RestResource(exported = true ,path = "/service/CompanyBranchInfo" , rel = "/service/CompanyBranchInfo")
@Consumes("application/json")
public interface CompanyBranchInfoRepo extends JpaRepository<CompanyBranchInfo, Long> {
}
