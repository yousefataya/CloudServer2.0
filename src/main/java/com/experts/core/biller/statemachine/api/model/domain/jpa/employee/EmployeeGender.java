package com.experts.core.biller.statemachine.api.model.domain.jpa.employee;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.CacheEvict;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name  = "employee_gender_lookup")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class EmployeeGender extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "deleted" , nullable = false)
    private boolean isDeleted;

    @Column(name  = "gender" , nullable = false)
    private String gender;


}
