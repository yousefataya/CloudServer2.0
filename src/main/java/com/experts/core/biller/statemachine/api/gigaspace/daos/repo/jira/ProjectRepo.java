package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.jira;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.planning.ProjectPlanning;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.projects.Project;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "Project Entity")
@RepositoryRestResource(path = "Project" , collectionResourceRel = "Project")
@RestResource(exported = true ,path = "/service/Project" , rel = "/service/Project")
@Consumes("application/json")
public interface ProjectRepo extends JpaRepository<Project, Long> {
}
