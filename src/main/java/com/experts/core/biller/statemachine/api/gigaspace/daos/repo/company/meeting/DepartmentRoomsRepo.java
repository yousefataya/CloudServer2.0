package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company.meeting;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.groupmeeting.MeetingCount;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.room.DepartmentRooms;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "DepartmentRooms Entity")
@RepositoryRestResource(path = "DepartmentRooms" , collectionResourceRel = "DepartmentRooms")
@RestResource(exported = true ,path = "/service/DepartmentRooms" , rel = "/service/DepartmentRooms")
@Consumes("application/json")
public interface DepartmentRoomsRepo extends JpaRepository<DepartmentRooms, Long> {
}
