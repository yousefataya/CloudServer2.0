package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.tasks;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.projects.Project;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.stage.ProjectStage;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.tasks.lookups.TaskType;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.performance.TaskIssueFaces;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name  = "hr_project_tasks")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Tasks extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "task_name" , nullable = false)
    private String taskName;

    @Column(name  = "from_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;

    @Column(name  = "to_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "project_id" , nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "project_stage_id" , nullable = false)
    private ProjectStage projectStage;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "task_type_lookup" , nullable = false)
    private TaskType taskType;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "tasks")
    private List<TaskIssueFaces> taskIssueFaces;
    /* project reference key */

    /* stage reference key */

    /* task type reference key */

}
