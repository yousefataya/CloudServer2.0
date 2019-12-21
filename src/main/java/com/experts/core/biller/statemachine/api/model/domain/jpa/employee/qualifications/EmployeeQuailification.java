package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.qualifications;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.qualifications.lookups.QuailificationLookup;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import net.bytebuddy.description.type.TypeList;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "hr_employee_quailification")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class EmployeeQuailification extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "qualification_name" , nullable = false)
    private String quailificationName;

    @Column(name  = "qualify_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date qualifyDate;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "department_id" , nullable = false)
    private OrgnizationDepartment orgnizationDepartment;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch =  FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "qualification_lookup_id" , nullable = false)
    private QuailificationLookup quailificationLookup;

    /* location reference key */

    /* employee reference key */

    /* department reference key */

    /* quailification key reference key */

}
