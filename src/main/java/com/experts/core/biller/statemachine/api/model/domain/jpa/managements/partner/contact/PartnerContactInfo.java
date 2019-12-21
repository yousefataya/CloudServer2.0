package com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.contact;

import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.PartenerMainInfo;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "partner_contact_info")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class PartnerContactInfo extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "main_phone" , nullable = false)
    private String mainPhone;

    @Column(name  = "main_mobile" , nullable = false)
    private String mainMobile;

    @Column(name  = "main_mail" , nullable = false)
    private String mainMail;

    @Column(name = "issue_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "partner_id" , nullable = false)
    private PartenerMainInfo partenerMainInfo;

    @ManyToOne(fetch = FetchType.LAZY , cascade =   CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;


    /* organization reference key */



}
