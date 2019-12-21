package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.evaluations;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "hr_employee_evaulations")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class EmployeeEvaluations extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "title" , nullable = false)
    private String title;

    @Column(name  = "evaluation_title" , nullable = false)
    private String evaluationTitle;

    @Column(name  = "leader_evluate"  , nullable = false)
    private String evluate;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "department_id" , nullable = false)
    private OrgnizationDepartment orgnizationDepartment;

    /* employee reference key  */

    /* department reference key */

    @Column(name  = "conculsion" , nullable = false)
    private String conculsion;

    @Column(name  = "start_date" , nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name  = "deadline" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;

    @Column(name  = "direct_manager" , nullable = false)
    private String directManager;

    @Column(name  = "commonts" , nullable = false)
    private String commonts;



    /* */

}
