package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.planning;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.notifications.NotificationPlan;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.projects.Project;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.stage.ProjectStage;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hr_project_planning")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class ProjectPlanning extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "project_id" , nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "notification_id" , nullable = true)
    private NotificationPlan notificationPlan;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "project_stage_id" , nullable = false)
    private ProjectStage projectStage;

    /* project reference key */

    /* project notification key */

    /* project stage reference key */

    @Column(name  = "plan_name" , nullable = false)
    private String planName;

    @Column(name  = "from_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;

    @Column(name  = "deadline" , nullable = false)
    @Temporal(TemporalType.DATE)
    private Date deadline;

    @Column(name  = "plan_title" , nullable = false)
    private String planTitle;

}
