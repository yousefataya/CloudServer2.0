package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.experinces.lookup;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.experinces.EmployeeExperinces;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "experinces_lookup")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class ExperincesLookup extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "experince_name" , nullable = false)
    private String valueExperince;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL ,mappedBy = "experincesLookup")
    private List<EmployeeExperinces> employeeExperinces;
}
