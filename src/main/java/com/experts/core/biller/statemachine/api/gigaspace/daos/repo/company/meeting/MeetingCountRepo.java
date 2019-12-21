package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company.meeting;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.branch.CompanyBranchInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.groupmeeting.MeetingCount;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "MeetingCount Entity")
@RepositoryRestResource(path = "MeetingCount" , collectionResourceRel = "MeetingCount")
@RestResource(exported = true ,path = "/service/MeetingCount" , rel = "/service/MeetingCount")
@Consumes("application/json")
public interface MeetingCountRepo extends JpaRepository<MeetingCount, Long> {
}
