package com.experts.core.biller.statemachine.api.model.domain.jpa.crm.stakeholder;

import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.CacheEvict;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name  = "stakeholder_main_info")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class StakeHolderMainInfo extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
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

    @ManyToOne(fetch  = FetchType.LAZY , cascade =  CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "stakeHolderMainInfo")
    private List<CrmStakeHoldrContract> crmStakeHoldrContracts;

    @OneToMany(fetch =  FetchType.LAZY , mappedBy = "stakeHolderMainInfo" , cascade = CascadeType.ALL)
    private List<CmStakeHolderDocs> cmStakeHolderDocs;


    /* organization reference key */

}
