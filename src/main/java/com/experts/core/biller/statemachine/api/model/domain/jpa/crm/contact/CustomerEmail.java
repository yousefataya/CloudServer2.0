package com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact;

import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.lookup.CustomerEmailLookup;
import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.customer.CustomerDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.CacheEvict;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Table(name  = "customer_email")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class CustomerEmail extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "email" , nullable = false)
    @Email
    private String email;

    @Column(name = "issue_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "customer_id" , nullable = false)
    private CustomerDetails customerDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "customer_email_lookup" , nullable = false)
    private CustomerEmailLookup customerEmailLookup;

    /* customer reference key */

    /* organization reference key */

    /* email lookup reference key */

}
