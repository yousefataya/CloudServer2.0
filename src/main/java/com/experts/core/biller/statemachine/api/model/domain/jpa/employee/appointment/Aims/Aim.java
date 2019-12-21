package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Aims;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Appointment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.MeetingInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name  = "hr_aim_appointment")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Aim extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "value_text" , nullable = false)
    private String text;

    @Column(name = "question" , nullable = false)
    private String question;

    @Column(name  = "answer" , nullable = true)
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "department_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade =CascadeType.ALL)
    @JoinColumn(name  = "appointment_id" , nullable = true)
    private Appointment appointment;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinColumn(name  = "meeting_id" , nullable = true)
    private MeetingInfo meetingInfo;
    /* employee reference key */

    /* department reference key */

    /* appointment reference key */

}
