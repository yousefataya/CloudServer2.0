package com.experts.core.biller.statemachine.api.model.domain.jpa.crm.stakeholder;


import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.stakeholder.lookups.StakeHolderType;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.dialect.Oracle10gDialect;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "stakeholder_contract_doc")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class CmStakeHolderDocs extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "doc_body" , nullable = false)
    private byte[] doc;

    @Column(name  = "issue_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "stake_holder_id" , nullable = false)
    private StakeHolderMainInfo stakeHolderMainInfo;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "crm_stakeholder_contract" , nullable = false)
    private CrmStakeHoldrContract crmStakeHoldrContract;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "doc_type" , nullable = false)
    private StakeHolderType stakeHolderType;

    /* organization reference key */

    /* stakeholder reference key */

    /* stakeholder contract referenc key */

}
