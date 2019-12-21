package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.tasks.lookups;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.tasks.Tasks;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "hr_task_type")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class TaskType extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name = "notes" , nullable = true)
    private String notes;

    @Column(name  = "task_type" , nullable = false)
    private String taskType;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL ,mappedBy = "taskType")
    private List<Tasks> tasks;
}
