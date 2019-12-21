package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.jira;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.projects.Project;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.stage.ProjectStage;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "ProjectStage Entity")
@RepositoryRestResource(path = "ProjectStage" , collectionResourceRel = "ProjectStage")
@RestResource(exported = true ,path = "/service/ProjectStage" , rel = "/service/ProjectStage")
@Consumes("application/json")
public interface ProjectStageRepo extends JpaRepository<ProjectStage, Long> {
}
