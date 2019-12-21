package com.experts.core.biller.statemachine.api.model.domain.jpa.crm.customer;

import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.CrmCustomerContact;
import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.CustomerEmail;
import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.CustomerMobile;
import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.CustomerPhone;
import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.customer.details.CustomerGender;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name  = "customer_main_info")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class CustomerDetails extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name = "issue_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    /* organization reference key */

    @Column(name  = "first_name" , nullable = false)
    private String firstName;

    @Column(name  = "second_name" , nullable = false)
    private String secondName;

    @Column(name  = "last_name" , nullable = false)
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private CustomerGender genders;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "customers")
    private List<CrmCustomerContract> crmCustomerContracts;

    @OneToMany(cascade = CascadeType.ALL , fetch =  FetchType.LAZY , mappedBy = "customerDetails")
    private List<CrmCustomerDocs> crmCustomerDocs;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "customerDetails")
    private List<CustomerPhone> customerPhones;

    @OneToMany(cascade = CascadeType.ALL  , fetch = FetchType.LAZY , mappedBy = "customerDetails")
    private List<CustomerMobile> customerMobiles;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "customerDetails")
    private List<CustomerEmail> customerEmails;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "customerDetails")
    private List<CrmCustomerContact> crmCustomerContacts;

    /* gender reference key */
}
