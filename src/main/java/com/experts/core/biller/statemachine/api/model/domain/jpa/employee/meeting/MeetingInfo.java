package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Aims.Aim;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.attendance.Attendance;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.groupmeeting.MeetingCount;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.room.RoomInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "meeting_info")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class MeetingInfo extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name = "meeting_name" , nullable = false)
    private String meetingName;

    @Column(name  = "meeting_reason" , nullable = false)
    private String meetingReason;

    /* Business Process Management service Id */

    @Column(name  = "execution_id" , nullable = false)
    private String businessProcessExecutionId;

    @Column(name = "meeting_no" , nullable = false)
    private int meetingNo;

    /* organization reference key */

    @ManyToOne(fetch = FetchType.LAZY , cascade =  CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "department_id" , nullable = false)
    private OrgnizationDepartment orgnizationDepartment;


    /* department reference key */

    /* organization department leader*/

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "meetingInfo" , cascade = CascadeType.ALL)
    private List<Attendance> attendances;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "meetingInfo")
    private List<MeetingCount> meetingCounts;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "meetingInfo")
    private List<RoomInfo> roomInfos;

    @Column(name  = "approved" , nullable = false)
    private boolean isApproved = false;

    @OneToMany(fetch = FetchType.LAZY ,  cascade = CascadeType.ALL , mappedBy = "meetingInfo")
    private List<Aim> aims;

    /* aim reference key */
}
