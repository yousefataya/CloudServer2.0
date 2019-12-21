package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.evaluations.tasks;


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
@Table(name  = "hr_evaluation_tasks")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class EmployeeEvaluationTasks extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "task_name" , nullable = false)
    private String taskName;

    @Column(name  = "team_leader" , nullable = false)
    private String teamLeader;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo;

    @ManyToOne(fetch = FetchType.LAZY , cascade =  CascadeType.ALL)
    @JoinColumn(name  = "department_id" , nullable = false)
    private OrgnizationDepartment orgnizationDepartment;
    /* reference employee key */

    /* department reference key */

    /* position team reference key */

    @Column(name  = "absotacles" , nullable = false)
    private String abostacles;

    @Column(name  = "from_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;

    @Column(name  = "to_date" , nullable = false)
    @Temporal(TemporalType.DATE)
    private Date toDate;

}
