package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company.meeting;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.room.RoomInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.room.lookup.RoomLookup;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "RoomLookup Entity")
@RepositoryRestResource(path = "RoomLookup" , collectionResourceRel = "RoomLookup")
@RestResource(exported = true ,path = "/service/RoomLookup" , rel = "/service/RoomLookup")
@Consumes("application/json")
public interface RoomLookupRepo extends JpaRepository<RoomLookup, Long> {
}
