package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.room;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.leaders.OrganizationDepartmentLeader;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.room.lookup.RoomLookup;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name  = "department_rooms_lookup")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class DepartmentRooms extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "room_no" , nullable = false)
    private String roomNo;

    @Column(name  = "room_name" , nullable = false)
    private String roomName;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "department_id" , nullable = false)
    private OrgnizationDepartment  orgnizationDepartment;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;
    /* department reference key */

    /* organization reference key */

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "room_leader_id" , nullable = false)
    private OrganizationDepartmentLeader organizationDepartmentLeader;
    /* department leader reference key */

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "room_lookup_id" , nullable = false)
    private RoomLookup roomLookup;

    /* room lookup reference key */
}
