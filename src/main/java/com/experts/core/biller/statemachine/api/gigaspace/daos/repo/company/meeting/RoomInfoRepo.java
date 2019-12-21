package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company.meeting;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.groupmeeting.MeetingCount;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.room.RoomInfo;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "RoomInfo Entity")
@RepositoryRestResource(path = "RoomInfo" , collectionResourceRel = "RoomInfo")
@RestResource(exported = true ,path = "/service/RoomInfo" , rel = "/service/RoomInfo")
@Consumes("application/json")
public interface RoomInfoRepo extends JpaRepository<RoomInfo, Long> {
}
