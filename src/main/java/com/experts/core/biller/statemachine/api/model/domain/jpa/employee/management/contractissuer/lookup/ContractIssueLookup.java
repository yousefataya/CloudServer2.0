package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contractissuer.lookup;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contractissuer.DepartmentContractIssuer;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "contract_issue_lookup")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class ContractIssueLookup extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "issue_type" , nullable = false)
    private String issueType;

    @OneToMany(fetch = FetchType.LAZY ,  cascade = CascadeType.ALL , mappedBy = "contractIssueLookup")
    private List<DepartmentContractIssuer> departmentContractIssuers;
}
