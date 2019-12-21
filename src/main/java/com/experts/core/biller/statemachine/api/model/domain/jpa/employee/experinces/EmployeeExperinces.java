package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.experinces;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.experinces.lookup.ExperincesLookup;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "hr_employee_experinces")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class EmployeeExperinces extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "department_id" , nullable = false)
    private OrgnizationDepartment orgnizationDepartment;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "experinces_lookup" , nullable = false)
    private ExperincesLookup experincesLookup;

    /* employee reference key */

    /* department reference key */

    /* Experince lookup key */

    @Column(name  = "experince_name" , nullable = false)
    private String experinceName;

    @Column(name  = "title" , nullable = false)
    private String title;

    @Column(name  = "company_name" , nullable = false)
    private String companyName;

    @Column(name  = "company_mobile" , nullable = false)
    private String companyContactMobile;

    @Column(name  = "company_phone" , nullable = false)
    private String companyContactPhone;

    @Column(name  = "leadership" , nullable = false)
    private String leaderShip;

    @Column(name  = "project_name" , nullable = false)
    private String projectsName;

    @Column(name  = "resposibilities" , nullable = false)
    private String projectResposiblitiy;

    @Column(name  = "level_value" , nullable = false)
    private int level;


}
