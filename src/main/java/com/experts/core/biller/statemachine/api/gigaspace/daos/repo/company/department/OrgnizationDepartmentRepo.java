package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company.department;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.branch.CompanyBranchInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "OrgnizationDepartment Entity")
@RepositoryRestResource(path = "OrgnizationDepartment" , collectionResourceRel = "OrgnizationDepartment")
@RestResource(exported = true ,path = "/service/OrgnizationDepartment" , rel = "/service/OrgnizationDepartment")
@Consumes("application/json")
public interface OrgnizationDepartmentRepo extends JpaRepository<OrgnizationDepartment, Long> {
}
