package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.organization;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "organization_main_info")
@Data
/*@Builder*/
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Inheritance(strategy = InheritanceType.JOINED)
/*@NoArgsConstructor*/
public class OrganizationMainInfo extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpire;

    @Column(name  = "org_name" , nullable = false)
    private String orgName;

    @Column(name  = "org_official_name" , nullable = false)
    private String orgOfficalName;

    @Column(name  = "org_group_name" , nullable = true)
    private String orgGroupName;

    @Column(name  = "issue_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

}
