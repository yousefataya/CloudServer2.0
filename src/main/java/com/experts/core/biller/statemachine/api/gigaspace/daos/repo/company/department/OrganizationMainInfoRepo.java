package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company.department;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.organization.OrganizationMainInfo;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "OrganizationMainInfo Entity")
@RepositoryRestResource(path = "OrganizationMainInfo" , collectionResourceRel = "OrganizationMainInfo")
@RestResource(exported = true ,path = "/service/OrganizationMainInfo" , rel = "/service/OrganizationMainInfo")
@Consumes("application/json")
public interface OrganizationMainInfoRepo  extends JpaRepository<OrganizationMainInfo, Long> {
}
