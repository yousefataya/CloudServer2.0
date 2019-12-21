package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.notifications;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "general_notifications")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class GeneralNotification extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String derscription;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "nofification_name" , nullable = false)
    private String notificationName;

    @Column(name  = "title" , nullable = false)
    private String title;

    @Column(name  = "notification_body" , nullable = false)
    private String body;

    @Column(name  = "fromDate" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;

    @Column(name  = "to_date" , nullable = false)
    private Date toDate;

    @Column(name  = "viewd_notification" , nullable = false)
    private boolean isViewed = false;


    @ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;


    @ManyToOne(fetch = FetchType.LAZY ,  cascade = CascadeType.ALL)
    @JoinColumn(name  = "department_id" , nullable = false)
    private OrgnizationDepartment orgnizationDepartment;
    /* employee reference key */

    /* organization reference key */

    /* department reference key */



}
