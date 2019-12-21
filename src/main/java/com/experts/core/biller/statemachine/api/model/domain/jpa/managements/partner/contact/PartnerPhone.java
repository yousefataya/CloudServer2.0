package com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.contact;

import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.PartenerMainInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.contact.lookup.PartnerPhoneLookup;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "partner_phone_info")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class PartnerPhone extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "issue_date" , nullable = false)
    private Date issueDate;

    @Column(name  = "phone_no" , nullable = false)
    private String phoneNo;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "partner_id" , nullable = false)
    private PartenerMainInfo partenerMainInfo;


    @ManyToOne(fetch = FetchType.LAZY , cascade =  CascadeType.ALL)
    @JoinColumn(name  = "partner_phone_lookup" , nullable = false)
    private PartnerPhoneLookup partnerPhoneLookup;

    /* organization reference key */

    /* phone lookup reference key */

    /* partner contract info reference key */

}
