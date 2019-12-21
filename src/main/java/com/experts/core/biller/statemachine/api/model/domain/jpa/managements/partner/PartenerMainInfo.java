package com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract.ContractMainParteners;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.contact.PartnerContactInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.contact.PartnerEmail;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.contact.PartnerMobile;
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
@Table(name  = "partner_main_info")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class PartenerMainInfo extends BaseEntity {


    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "partner_name" , nullable = false)
    private String partnerName;

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY )
    @JoinColumn(name = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;


    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "partenerMainInfo")
    private List<PartnerEmail> partnerEmailList;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "partenerMainInfo")
    private List<PartnerMobile> partnerMobiles;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "partenerMainInfo")
    private List<PartnerPhone> partnerPhones;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "partenerMainInfo")
    private List<PartnerContactInfo> partnerContactInfos;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "partenerMainInfo")
    private List<ContractMainParteners> contractMainParteners;

}
