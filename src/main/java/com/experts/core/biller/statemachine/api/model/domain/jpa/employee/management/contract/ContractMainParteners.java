package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract;


import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.PartenerMainInfo;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name  = "company_main_partner")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class ContractMainParteners extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "partner_id" , nullable = false)
    private PartenerMainInfo  partenerMainInfo;
    /* partner reference key */

    @Column(name  = "partner_name" , nullable = false)
    private String partnerName;

    @Column(name  = "person_customer" , nullable = false)
    private boolean isPersonCustomer;

    @Column(name  = "company_customer" , nullable = false)
    private boolean isCompanyCustomer;

    @Column(name  = "issue_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    @Column(name  = "main_role" , nullable = true)
    private String mainRole;

    @Column(name = "sales_role" , nullable = true)
    private String salesRole;

    @Column(name  = "product_manager_role" , nullable = true)
    private String productManagerRole;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "contractMainParteners")
    private List<ContractMainPartenerDocs> contractMainPartenerDocs;
}
