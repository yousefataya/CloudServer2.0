package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.lookups.AlertType;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name  = "hr_absence_team_notification")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL , region = "defaultCache")
public class AbsenceTeamNotification extends BaseEntity {

    /* absence reference key*/

    @Column(name  = "notification" , nullable = false)
    private String notifications;

    @Column(name  = "title" , nullable = false)
    private String title;

    @Column(name  = "text_value" , nullable = false)
    private String text;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "approved" , nullable = false)
    private boolean isApproved;

    /* Business Process Key*/

    @Column(name  = "alert_title" , nullable = false)
    private String alertTitle;

    @Column(name  = "alert_type" , nullable = false)
    private String alertType;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinColumn(name  = "alert_type_id" , nullable = false)
    private AlertType type;

   /*reference key alert type*/

}
