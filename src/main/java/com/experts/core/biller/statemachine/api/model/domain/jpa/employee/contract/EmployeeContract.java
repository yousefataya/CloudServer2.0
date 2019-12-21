package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contract;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contract.lookups.EmpoyeeContractLookup;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.leaders.lookup.EmployeeLeaderRole;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "hr_employee_contract")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class EmployeeContract extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "contract_name" , nullable = false)
    private String contractName;

    @Column(name  = "initial_period" , nullable = false)
    private Date initialPeriod;

    @Column(name  = "initial_period_end" , nullable = false)
    private Date initialPeriodEnd;

    @Column(name  = "renewable_contract" , nullable = false)
    private boolean isRenewable;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo;
    /* employee reference key */

    /* leadership reference key */

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_leader_id" , nullable = false)
    private EmployeeLeaderRole employeeLeaderRole;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_contract_lookup" , nullable = false)
    private EmpoyeeContractLookup empoyeeContractLookup;
    /* Employee Contract Reference key */

}
