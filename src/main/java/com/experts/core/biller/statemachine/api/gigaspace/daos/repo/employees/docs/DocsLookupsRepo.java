package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees.docs;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.docs.EmployeeDocs;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.docs.lookups.DocsLookups;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "DocsLookups Entity")
@RepositoryRestResource(path = " DocsLookups" , collectionResourceRel = " DocsLookups")
@RestResource(exported = true ,path = "/service/DocsLookups" , rel = "/service/ DocsLookups")
@Consumes("application/json")
public interface DocsLookupsRepo extends JpaRepository<DocsLookups, Long> {
}
