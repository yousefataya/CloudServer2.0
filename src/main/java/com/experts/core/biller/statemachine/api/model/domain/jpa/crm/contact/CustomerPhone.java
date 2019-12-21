package com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact;

import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.lookup.CustomerPhoneLookup;
import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.customer.CustomerDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;

@Entity
@Table(name  = "customer_phone_details")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class CustomerPhone extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "phone" , nullable = false)
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "customer_id" , nullable = false)
    private CustomerDetails customerDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "customer_phone_lookup" , nullable = false)
    private CustomerPhoneLookup customerPhoneLookup;

    /* customer reference key */

    /* organization reference key */

    /* phone lookup reference key */
}
