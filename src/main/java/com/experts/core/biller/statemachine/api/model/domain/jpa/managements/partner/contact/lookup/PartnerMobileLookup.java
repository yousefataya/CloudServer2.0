package com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.contact.lookup;


import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.contact.PartnerMobile;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "partner_mobile_lookup")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class PartnerMobileLookup extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "mobile_type" , nullable = false)
    private String mobileType;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "partnerMobileLookup")
    private List<PartnerMobile> partnerMobileList;

}
