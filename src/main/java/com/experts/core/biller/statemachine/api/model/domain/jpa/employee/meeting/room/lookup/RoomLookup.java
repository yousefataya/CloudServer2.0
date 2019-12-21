package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.room.lookup;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.room.DepartmentRooms;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.room.RoomInfo;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.CacheEvict;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "room_lookup")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class RoomLookup extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "room_type" , nullable = false)
    private String roomType;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "roomLookup")
    private List<DepartmentRooms> departmentRooms;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "roomLookup" , cascade = CascadeType.ALL)
    private List<RoomInfo> roomInfos;

 }
