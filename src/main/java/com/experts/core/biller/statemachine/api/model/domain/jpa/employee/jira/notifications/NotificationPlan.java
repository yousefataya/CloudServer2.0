package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.notifications;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.planning.ProjectPlanning;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name  = "hr_notification_plan")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class NotificationPlan extends BaseEntity{

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "title" , nullable = false)
    private String title;

    @Column(name  = "value_text" , nullable = false)
    private String valueText;

    @Column(name  = "from_date" , nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Column(name  = "disappear_time" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date disappear;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "notificationPlan")
    private List<ProjectPlanning> projectPlannings;
    /* reference employee key */

    /* project reference key */





}
