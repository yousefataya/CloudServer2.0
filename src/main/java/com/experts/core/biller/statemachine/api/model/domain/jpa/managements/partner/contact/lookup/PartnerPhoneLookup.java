package com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.contact.lookup;

import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.contact.PartnerPhone;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.CacheEvict;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "partner_phone_lookup")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class PartnerPhoneLookup extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name = "phone_type" , nullable = false)
    private String phoneType;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "partnerPhoneLookup")
    private List<PartnerPhone> partnerPhoneList;

}
