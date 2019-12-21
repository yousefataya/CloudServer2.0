package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.policy;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.policy.lookup.PolicyHrDocs;
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
@Table(name  = "hr_employee_policy")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class EmployeeExtraPolicy extends BaseEntity {
    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "xls_doc" , nullable = false)
    private byte[] xls;

    @Column(name  = "issue_date" , nullable = false)
    private Date issueDate;

    @Column(name  = "approved" , nullable = false)
    private boolean isApproved = false;

    /* business process approved Id*/

    @Column(name  = "execution_id" , nullable = false)
    private String processExecutionId;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id" , nullable = false)
    private OrgnizationDepartment orgnizationDepartment;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @OneToMany(fetch = FetchType.LAZY , cascade =   CascadeType.ALL , mappedBy = "employeeExtraPolicy")
    private List<PolicyHrDocs> policyHrDocs;


    /* employee extra policy */

    /* employee reference key */

    /* organization reference key */
}
