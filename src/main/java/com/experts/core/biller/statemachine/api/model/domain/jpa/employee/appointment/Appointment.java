package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Aims.Aim;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="hr_appointment")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Appointment extends BaseEntity {

    @Column(name  = "title" , nullable = false)
    private String title;

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "start_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date   startDate;

    @Column(name  = "end_date" , nullable = false)
    @Temporal(TemporalType.TIME)
    private Date   endDate;

    @Column(name  = "total_hours" , nullable = false)
    private int totalHours;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo;


    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id" , nullable = false)
    private OrganizationDetails  organizationDetails;



    /* reference key employee */

    /* department reference key */

    /* Business Process Id */

    /* Business Process Excution Id */

    /* Person Id reference key */

    /* docs reference key */

    /* appointment reference key */


    /* reference location key */

    /* */

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "appointment")
    private List<Aim> aims;
}
