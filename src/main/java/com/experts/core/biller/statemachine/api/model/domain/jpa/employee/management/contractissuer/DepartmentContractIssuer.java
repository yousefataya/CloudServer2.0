package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contractissuer;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contractissuer.lookup.ContractIssueLookup;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.CacheEvict;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "company_department_issuer")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class DepartmentContractIssuer extends BaseEntity {
    /* department contract issuer */

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "issue_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    @Column(name  = "renewable" , nullable = false)
    private boolean isRenewable = false;

    @Column(name  = "renew_date" , nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date renewDate;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL )
    @JoinColumn(name  = "department_id" , nullable = false)
    private OrgnizationDepartment orgnizationDepartment;

    @ManyToOne(fetch = FetchType.LAZY , cascade =  CascadeType.ALL)
    @JoinColumn(name  = "contract_issue_lookup" , nullable = false)
    private ContractIssueLookup  contractIssueLookup;

    /* Contract Issue Lookup */

    /* orgnization reference key */

    /* organization department reference key */


}
