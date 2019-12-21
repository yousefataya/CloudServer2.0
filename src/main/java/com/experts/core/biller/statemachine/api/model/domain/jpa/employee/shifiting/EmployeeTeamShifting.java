package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.shifiting;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.shifiting.lookup.TeamShiftType;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.opensaml.saml2.metadata.Organization;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name  = "employee_team_shifting")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class EmployeeTeamShifting extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "shift_name" , nullable = false)
    private String shiftName;

    @Column(name  = "shift_no" , nullable = false)
    private String shiftNo;

    @Column(name  = "from_date" , nullable = false)
    @Temporal(TemporalType.TIME)
    private Date fromDate;

    @Column(name  = "to_date" , nullable = false)
    @Temporal(TemporalType.TIME)
    private Date toDate;

    @Column(name  = "issue_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;


    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "department_id" , nullable = false)
    private OrgnizationDepartment orgnizationDepartment;


    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "team_shift_lookup" , nullable = false)
    private TeamShiftType teamShiftType;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy= "employeeTeamShifting" )
    private List<ShiftTeamMember>  shiftTeamMembers;

    /* organization refrence key */

    /* department reference key  */

    /* shift lookup type reference key */
}
