package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.monthly.SalaryStatistic;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.slip.lookup.SalarySlipType;
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
@Table(name  = "hr_employee_basic_salary")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class EmployeeBasicSalary extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "amount" , nullable = false)
    private int amount;

    @Column(name  = "salary_type" , nullable = false)
    private String salaryType;

    /* basic salary type */

    /* employee reference key */

    /* organization reference key */

    @Column(name  = "paid_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date paidDate;

    @Column(name  = "approved" , nullable = false)
    private boolean isApproved = false;

    @Column(name  = "approved_date" , nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDate;

    /* Business Process Approved Salary */

    /* currency lookup reference key */


    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "salary_slip_lookup" , nullable = false)
    private SalarySlipType salarySlipType;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "department_id" , nullable = false)
    private OrgnizationDepartment  orgnizationDepartment;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeBasicSalary")
    private List<SalaryStatistic> salaryStatistics;
}
