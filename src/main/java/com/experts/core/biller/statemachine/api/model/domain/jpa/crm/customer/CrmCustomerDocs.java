package com.experts.core.biller.statemachine.api.model.domain.jpa.crm.customer;

import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.customer.lookup.CustomerDocLookup;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "crm_customer_docs")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class CrmCustomerDocs extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired =  false;

    @Column(name  = "doc" , nullable = false)
    private byte[] doc;

    /* customer reference key */

    /* organization reference key */

    /* doc type customer lookup reference key */

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name  = "customer_id" , nullable = false)
    private CustomerDetails customerDetails;

    @Column(name  = "issue_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "doc_lookup_id" , nullable = false)
    private CustomerDocLookup customerDocLookup;

}
