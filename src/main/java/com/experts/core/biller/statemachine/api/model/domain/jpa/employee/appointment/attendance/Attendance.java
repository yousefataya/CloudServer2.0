package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.attendance;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.Absence;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.leaders.lookup.EmployeeLeaderRole;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.MeetingInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name  = "hr_appointment_attendance")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Attendance extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "absence" , nullable = false)
    private boolean isAbsence;

    /* employee reference key*/

    /* department reference key */

    /* meeting reference key */

    /* employee leader ship key */

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL )
    @JoinColumn(name = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "department_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_leader_id" , nullable = false)
    private EmployeeLeaderRole employeeLeaderRole;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "meeting_id" , nullable = true)
    private MeetingInfo meetingInfo;

    /* absence reference key */

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "absence_id" , nullable = true)
    private Absence absence;

    @Column(name  = "absence_reason" , nullable = true)
    private String absenceReason;

}
