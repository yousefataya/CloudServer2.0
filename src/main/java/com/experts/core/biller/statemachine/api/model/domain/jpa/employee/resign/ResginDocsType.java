package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.resign;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "resgin_docs_types")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class ResginDocsType extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "doc_type" , nullable = false)
    private String docType;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "resginDocsType")
    private List<EmployeeResignDocs> employeeResignDocs;
}
