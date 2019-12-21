package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.skills;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.skills.lookups.SkillType;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import net.bytebuddy.description.type.TypeList;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "hr_employee_skills")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class EmployeeSkills extends BaseEntity {

    @Column(name = "description" , nullable = true)
    private String description;

    @Column(name = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name = "skill_key" , nullable = false)
    private String skillKey;

    @Column(name = "last_used" , nullable = false)
    @Temporal(TemporalType.DATE)
    private Date lastUsedDate;

    @Column(name  = "years_value" , nullable = true)
    private int years;

    @Column(name  = "months_value" , nullable = true)
    private int months;

    @Column(name  = "days" , nullable = true)
    private int days;

    @Column(name = "skill_level" , nullable = false)
    private int level;


    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "department_id" , nullable = false)
    private OrgnizationDepartment orgnizationDepartment;

    @ManyToOne(fetch = FetchType.LAZY ,  cascade = CascadeType.ALL)
    @JoinColumn(name  = "skill_lookup" , nullable = false)
    private SkillType skillType;

    /* employee reference key */

    /* department refrenence key */

    /* skill type reference key */

    /* skill type reference key */

}
