package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees.docs;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.lookups.AbsenceCatogry;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.docs.EmployeeDocs;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "EmployeeDocs Entity")
@RepositoryRestResource(path = "EmployeeDocs" , collectionResourceRel = "EmployeeDocs")
@RestResource(exported = true ,path = "/service/EmployeeDocs" , rel = "/service/EmployeeDocs")
@Consumes("application/json")
public interface EmployeeDocsRepo extends JpaRepository<EmployeeDocs, Long> {
}
