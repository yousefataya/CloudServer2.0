package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.performance;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name  = "job_accomplishment")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class JobAccomplishment extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "task_catogry" , nullable = false)
    private String tasksCatogry;

    /* task catogry reference key */



    /* employee performance reference key */

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_performance_id" , nullable = false)
    private EmployeePerfomance  employeePerfomance;

    @Column(name  = "task_completed" , nullable = false)
    private boolean taskCompleted;

    @Column(name  = "issue_faces" , nullable = false)
    private String issuesFaces;

    @Column(name  = "tutorail" , nullable = true)
    private String resources;
}
