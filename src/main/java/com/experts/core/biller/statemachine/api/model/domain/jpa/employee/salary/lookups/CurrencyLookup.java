package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.lookups;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.history.SalaryStatisticHistory;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "currency_lookup")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class CurrencyLookup extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "currency" , nullable = false)
    private String currency;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy =  "currencyLookup")
    private List<SalaryStatisticHistory> salaryStatisticHistory;
}
