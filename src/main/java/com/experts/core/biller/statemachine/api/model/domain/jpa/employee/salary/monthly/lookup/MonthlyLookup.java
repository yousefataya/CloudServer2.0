package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.monthly.lookup;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.monthly.SalaryStatistic;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "salary_monthly_lookup")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class MonthlyLookup extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "value_type" , nullable = false)
    private String typeValue;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "monthlyLookup")
    private List<SalaryStatistic>  salaryStatistics;
}
