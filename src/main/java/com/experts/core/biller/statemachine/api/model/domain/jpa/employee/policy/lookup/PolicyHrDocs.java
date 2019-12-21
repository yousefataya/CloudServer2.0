package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.policy.lookup;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.policy.EmployeeExtraPolicy;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.policy.EmployeePolicyHr;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name  = "policy_docs_hr_xls")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class PolicyHrDocs extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "xls_type" , nullable = false)
    private String xlsType;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_extra_policy" , nullable = false)
    private EmployeeExtraPolicy employeeExtraPolicy;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_policy_id" , nullable = false)
    private EmployeePolicyHr employeePolicyHr;
}
