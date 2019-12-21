package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.branch;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.branch.lookup.CompanyBranchLookup;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.leaders.OrganizationDepartmentLeader;
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
@Table(name  = "company_branch_info")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class CompanyBranchInfo extends BaseEntity {

    @Column(name = "description" , nullable = true)
    private String desription;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    /* orgnization reference key */

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @Column(name  = "branch_name" , nullable = false)
    private String companyBranchName;

    /* location address reference key */

    /* employee contact reference key */

    @Column(name  = "estalishment_date" , nullable = false)
    private Date establishmentDate;

    /* contract issuers reference key */

    @Column(name  = "general_manager_name" , nullable = false)
    private String generalManager;

    /* general manager employee reference key */
    @Column(name  = "vice_pesisdent_name" , nullable = false)
    private String vicePersisdent;

    /* employee reference key vicepersisdent */

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "companyBranchInfo")
    private List<OrganizationDepartmentLeader> organizationDepartmentLeaders;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "company_branch_lookup" , nullable = false)
    private CompanyBranchLookup companyBranchLookup;

    /* branch lookup type reference key */
}
