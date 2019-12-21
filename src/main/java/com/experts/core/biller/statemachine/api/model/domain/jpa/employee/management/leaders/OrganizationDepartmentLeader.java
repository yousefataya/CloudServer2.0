package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.leaders;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.branch.CompanyBranchInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.room.DepartmentRooms;
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
@Table(name  = "organization_dept_leader")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class OrganizationDepartmentLeader extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo;
    /* employee reference key */

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    /* organization reference key */

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "branch_id" , nullable = false)
    private CompanyBranchInfo companyBranchInfo;
    /* branch reference key */

    @Column(name  = "assign_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date assignDate;

    @Column(name  = "role_name" , nullable = false)
    private String roleName;

    @Column(name  = "resposisbilities" , nullable = false)
    private String resposibilities;

    @Column(name  = "renew_contract" , nullable = false)
    private boolean renewContract = false;

    @Column(name  = "total_years" , nullable = false)
    private int totalYears;

    @Column(name  = "resgin_date" , nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date resginDate;

    @Column(name  = "resgin_reason" , nullable = true)
    private String resignReason;

    @OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL , mappedBy = "organizationDepartmentLeader")
    private List<DepartmentRooms> departmentRooms;


    /* Employee leader Role */

}
