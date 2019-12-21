package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.leaderships.EmployeeTeamMember;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "hr_employee_team_member")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class EmployeeTeamMember extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    /* employee reference key */

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo;


    @Column(name  = "from_date" , nullable = false)
    private Date fromDate;

    @Column(name  = "to_date" , nullable = true)
    private Date toDate;

    @Column(name  = "resposibilites" , nullable = false)
    private String resposibilites;

    @Column(name  = "to_present" , nullable = false)
    private boolean toPresent;


}
