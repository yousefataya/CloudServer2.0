package com.experts.core.biller.statemachine.api.model.domain.jpa.crm.customer.lookup;

import com.experts.core.biller.statemachine.api.constraints.Name;
import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.customer.CrmCustomerDocs;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import liquibase.change.DatabaseChangeProperty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "customer_doc_lookup")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class CustomerDocLookup extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "doc_type" , nullable = false)
    private String docType;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "customerDocLookup")
    private List<CrmCustomerDocs> crmCustomerDocsList;
}
