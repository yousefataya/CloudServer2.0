package com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.contact;


import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.PartenerMainInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.contact.lookup.PartnerMobileLookup;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name  = "partner_mobile_info")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class PartnerMobile extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "mobile_number" , nullable = false)
    private String mobileNumber;

    @ManyToOne(fetch = FetchType.LAZY , cascade =  CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "partner_id" , nullable = false)
    private PartenerMainInfo partenerMainInfo;

    @ManyToOne(fetch =  FetchType.LAZY , cascade =  CascadeType.ALL)
    @JoinColumn(name  = "partner_mobile_lookup" , nullable = false)
    private PartnerMobileLookup partnerMobileLookup;
    /* organization reference key */

    /* partner contact info reference key */

    /* partner lookup  reference key */
}
