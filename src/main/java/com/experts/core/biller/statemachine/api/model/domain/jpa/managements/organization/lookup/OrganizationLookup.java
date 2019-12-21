package com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.lookup;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.CacheEvict;
import sun.print.BackgroundServiceLookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name  = "organization_details_lookup")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class OrganizationLookup extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description ;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "organization_catogry" , nullable = false)
    private String orgCatogry;


}
