package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.resign;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "resgin_employee_docs")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class EmployeeResignDocs extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "doc_name" , nullable = false)
    private String docName;

    /* docs reference key type lookup*/

    /* employee reference key */

    /* department reference key */

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_resign_id" , nullable = false)
    private EmployeeResign employeeResign;


    @ManyToOne(fetch = FetchType.LAZY , cascade =  CascadeType.ALL)
    @JoinColumn(name  = "resign_doc_lookup" , nullable = false)
    private ResginDocsType  resginDocsType;
    /*Business Process Management Id Cases*/

    @Column(name  = "issue_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    @Column(name  = "approved" , nullable = false)
    private boolean isApproved = false;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "doc" , nullable = false)
    private byte[] doc;
}
