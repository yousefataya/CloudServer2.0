package com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.contact.lookup;

import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.contact.PartnerEmail;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "partner_email_lookup")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class PartnerEmailLookup extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "email_type" , nullable = false)
    private String emailType;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "partnerEmailLookup")
    private List<PartnerEmail> partnerEmailList;
}
