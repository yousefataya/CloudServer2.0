package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.role;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.CacheEvict;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "organization_department_role")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class DepartmentRole extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    /* department reference key */

    @ManyToOne(fetch =  FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "departmenet_id" , nullable = false)
    private OrgnizationDepartment orgnizationDepartment;

    @Column(name  = "issue_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    @Column(name  = "role_description" , nullable = false)
    private String roleDescription;


}
