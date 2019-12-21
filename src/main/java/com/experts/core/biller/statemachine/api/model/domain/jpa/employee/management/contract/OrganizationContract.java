package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract;

import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name  = "company_contract")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class OrganizationContract extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "renewable" , nullable = false)
    private boolean isRenewable;

    @Column(name  = "from_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;

    @Column(name  = "to_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;

    @Column(name  = "renew_date" , nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date renewDate;

    @Column(name  = "renew_to_date" , nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date renewToDate;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails  organizationDetails;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL ,mappedBy = "organizationContract")
    private List<OragnizationContractDocs> oragnizationContractDocs;
}
