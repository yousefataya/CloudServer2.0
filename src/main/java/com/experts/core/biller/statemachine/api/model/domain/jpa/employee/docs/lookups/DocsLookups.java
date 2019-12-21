package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.docs.lookups;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.docs.EmployeeDocs;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "hr_employee_docs_lookup")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class DocsLookups extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "docs_type" , nullable =  false)
    private String docType;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "docsLookups")
    private List<EmployeeDocs> employeeDocs;
}