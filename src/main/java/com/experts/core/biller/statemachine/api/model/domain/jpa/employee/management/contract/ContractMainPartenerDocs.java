package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract.lookup.ContractDocsType;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract.lookup.ContractType;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "company_partner_docs")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class ContractMainPartenerDocs extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "contract_type_id" , nullable = false)
    private ContractType contractType;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "doc_type_id" , nullable = false)
    private ContractDocsType contractDocsType;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "contract_id" , nullable = false)
    private ContractMainParteners contractMainParteners;

    /* doc type reference key */

    /* contract main partener reference key */

    @Column(name  = "from_date" , nullable = false)
    private Date fromDate;

    @Column(name  = "expire_date" , nullable = true)
    private Date expireDate;

    @Column(name  = "doc_name" , nullable = false)
    private String docName;

    @Column(name  = "doc_body" , nullable = false)
    private byte[] doc;
}
