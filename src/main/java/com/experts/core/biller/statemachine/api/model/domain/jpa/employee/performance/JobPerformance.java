package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.performance;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "job_perfomance")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class JobPerformance extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "role_type" , nullable = false)
    private String roleType;

    @Column(name  = "role_name" , nullable = false)
    private String roleName;

    @Column(name  = "over_all_tasks" , nullable = false)
    private String overallTask;

    @Column(name   = "issue_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    /* employee performance reference key */

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_performance_id" , nullable = false)
    private EmployeePerfomance  employeePerfomance;

}

