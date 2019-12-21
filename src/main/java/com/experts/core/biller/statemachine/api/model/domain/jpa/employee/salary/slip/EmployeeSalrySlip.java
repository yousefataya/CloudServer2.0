package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.slip;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.slip.lookup.SalarySlipType;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "employee_salary_slip")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class EmployeeSalrySlip extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "issue_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    @Column(name = "paid_date" , nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date paidDate;

    /*Business Process Id */

    /* Business Exexution Id*/
    private String processExceutionId;

    /* employee rerefence key */

    /* organization refrence key */

    /* department reference key */

    @Column(name  = "approved" , nullable = false)
    private boolean isApproved = false;

    /* slip salary reference lookup */


    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "salary_slip_lookup" , nullable = false)
    private SalarySlipType salarySlipType;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "department_id" , nullable = false)
    private OrgnizationDepartment orgnizationDepartment;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo;

}
