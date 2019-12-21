package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.policy;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.Absence;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name  = "hr_absence_policy")
@Builder
@Data
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL , region = "defaultCache")
public class AbsencePolicy extends BaseEntity implements Serializable {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "policy_name" , nullable = false)
    private String policyName;

    @Column(name  = "policy_title" , nullable = false)
    private String policyTitle;

    @Column(name  = "policy_rule_name" , nullable = false)
    private String policyRuleName;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "absencePolicy")
    private List<Absence> absenceList;

    /* reference key Absence*/

    /* department reference key*/

    /* employee reference key*/



}
