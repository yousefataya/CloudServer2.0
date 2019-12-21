package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.projects;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.catogry.ProjectCatogry;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.planning.ProjectPlanning;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.stage.ProjectStage;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.tasks.Tasks;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name  = "hr_employee_project")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Project extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "project_name" , nullable = false)
    private String projectName;

    @Column(name  = "from_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;

    @Column(name  = "deadline" , nullable = true)
    @Temporal(TemporalType.DATE)
    private Date deadline;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "project_catogry_id" , nullable = false)
    private ProjectCatogry projectCatogry;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL ,mappedBy = "project")
    private List<ProjectPlanning> projectPlannings;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "project")
    private List<ProjectStage> projectStages;

    @OneToMany(fetch =  FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "project")
    private List<Tasks> tasks;
    /* company branch reference key */

    /* project catogry reference key */


}
