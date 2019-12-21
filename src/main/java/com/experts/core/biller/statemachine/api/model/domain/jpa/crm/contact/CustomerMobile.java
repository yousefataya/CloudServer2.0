package com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact;

import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.lookup.CustomerMobileLookup;
import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.customer.CustomerDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer_mobile_details")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class CustomerMobile extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "mobile_value" , nullable = false)
    private String mobile;

    @Column(name  = "issue_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "customer_id" , nullable = false)
    private CustomerDetails customerDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "customer_mobile_lookup" , nullable = false)
    private CustomerMobileLookup customerMobileLookup;
    /* customer reference key */

    /* orgainzation reference key */

    /* mobile lookup reference key */


}
