package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.jira;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.catogry.ProjectCatogry;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.planning.ProjectPlanning;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "ProjectPlanning Entity")
@RepositoryRestResource(path = "ProjectPlanning" , collectionResourceRel = "ProjectPlanning")
@RestResource(exported = true ,path = "/service/ProjectPlanning" , rel = "/service/ProjectPlanning")
@Consumes("application/json")
public interface ProjectPlanningRepo extends JpaRepository<ProjectPlanning, Long> {
}
