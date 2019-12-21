package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.CacheEvict;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "employee_salary_overtime")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class EmployeeOverTime extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "over_time_hours_calc" , nullable = false)
    private int overTimeHoursCalc;

    @Column(name  = "paid_hours" , nullable = false)
    private int paidHours;

    @Column(name  = "over_time_hours" , nullable = false)
    private int overTimeHours;

    @Column(name  = "issue_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    @Column(name  = "paid_date" , nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date paidDate;

    /* Business Management Id execution Id */

    @Column(name  = "exceution_id" , nullable = false)
    private String processExecutionId;

    /* employee reference key */

    /* organization reference key */

    /* department reference key */

    /* currency lookup reference key */

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "department_id" , nullable = false)
    private OrgnizationDepartment orgnizationDepartment;
}
