package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.history;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.lookups.CurrencyLookup;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "salary_statistic_history")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class SalaryStatisticHistory extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "issue_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    @Column(name  = "from_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;

    @Column(name  = "to_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id" , nullable = false)
    private OrgnizationDepartment orgnizationDepartment;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "currency_lookup" , nullable = false)
    private CurrencyLookup currencyLookup;



    /* employee reference key */

    /* organization reference key */

    /* department reference key */

    /* currency lookup reference key */

    /* employee monthly reference key */
}
