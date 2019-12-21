package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.lookups;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.Absence;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.apache.curator.shaded.com.google.common.util.concurrent.ListeningScheduledExecutorService;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "hr_absence_catogry")
@Data
@Builder
@Cache( usage = CacheConcurrencyStrategy.TRANSACTIONAL , region = "defaultCache")
public class AbsenceCatogry extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "value" , nullable = false)
    private String value;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "absenceCatogry")
    private List<Absence> absenceList;

}
