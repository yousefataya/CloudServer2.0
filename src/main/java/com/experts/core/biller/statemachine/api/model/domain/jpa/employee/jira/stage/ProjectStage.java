package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.stage;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.projects.Project;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.tasks.Tasks;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "hr_employee_project_stage")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class ProjectStage extends BaseEntity {

    @Column(name = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "stage_name" , nullable = false)
    private String stageName;

    @Column(name  = "title" , nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "project_id" , nullable = false)
    private Project project;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "projectStage")
    private List<Tasks> tasks;
    /* aim reference key */

    /* project reference key */

    /* project notification reference key */



}
