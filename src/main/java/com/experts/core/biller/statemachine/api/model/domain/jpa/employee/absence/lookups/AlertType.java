package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.lookups;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.AbsenceTeamNotification;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "hr_notifi_alert")
@Builder
@Data
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class AlertType extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "text_value" , nullable = false)
    private String textValue;

    @Column(name  = "type_name" , nullable = false)
    private String TypeName;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL ,mappedBy = "type")
    private List<AbsenceTeamNotification> absenceTeamNotificationList;
}
