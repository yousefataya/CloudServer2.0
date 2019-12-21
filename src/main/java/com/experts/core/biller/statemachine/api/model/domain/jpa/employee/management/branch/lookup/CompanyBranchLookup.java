package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.branch.lookup;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.branch.CompanyBranchInfo;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "company_branch_lookup")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class CompanyBranchLookup extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "branch_type" , nullable = false)
    private String branchType;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "companyBranchLookup")
    private List<CompanyBranchInfo> companyBranchInfos;
}
