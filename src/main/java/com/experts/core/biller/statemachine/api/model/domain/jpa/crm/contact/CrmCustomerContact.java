package com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact;

import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.customer.CustomerDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Table(name  = "crm_customer_contact")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class CrmCustomerContact extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "issue_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    @Column(name  = "main_mobile" , nullable = true)
    private String mainMobile;

    @Column(name  = "main_email" , nullable = true)
    @Email
    private String mainEmail;

    @Column(name  = "main_phone" , nullable = true)
    private String mainPhone;

    /* customer reference key */

    /* organization reference key */


    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name  = "customer_id" , nullable = false)
    private CustomerDetails customerDetails;



}
