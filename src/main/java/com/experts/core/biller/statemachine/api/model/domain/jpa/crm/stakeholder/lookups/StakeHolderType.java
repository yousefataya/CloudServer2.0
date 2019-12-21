package com.experts.core.biller.statemachine.api.model.domain.jpa.crm.stakeholder.lookups;

import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.stakeholder.CmStakeHolderDocs;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "stakeholder_doc")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class StakeHolderType extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "stake_holder" , nullable = false)
    private String stakeHolderType;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "stakeHolderType")
    private List<CmStakeHolderDocs> cmStakeHolderDocs;

}
