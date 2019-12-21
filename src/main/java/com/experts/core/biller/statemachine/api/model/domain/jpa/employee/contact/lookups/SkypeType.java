package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.lookups;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.Skype;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "skype_lookup")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class SkypeType extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name = "skype_type" , nullable = false)
    private String skypeType;

    @Column(name = "expired" , nullable = false)
    private boolean isExpired;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "skypeType" , cascade = CascadeType.ALL)
    private List<Skype> skypes;
}
