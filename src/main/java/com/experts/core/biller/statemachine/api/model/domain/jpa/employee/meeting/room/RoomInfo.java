package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.room;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.MeetingInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.room.lookup.RoomLookup;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "department_room_info")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class RoomInfo extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "room_name" , nullable = false)
    private String roomName;

    @Column(name  = "room_no" , nullable = false)
    private String roomNo;

    @ManyToOne(fetch = FetchType.LAZY , cascade  = CascadeType.ALL)
    @JoinColumn(name  = "meeting_info_id" , nullable = true)
    private MeetingInfo meetingInfo;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "department_id" , nullable = false)
    private OrgnizationDepartment orgnizationDepartment;
    /* meeting info reference key */

    /* organization reference key */

    /* department orgnization leader reference key */

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "room_lookup_id" , nullable = false)
    private RoomLookup roomLookup;

    /* room type lookup */


}
