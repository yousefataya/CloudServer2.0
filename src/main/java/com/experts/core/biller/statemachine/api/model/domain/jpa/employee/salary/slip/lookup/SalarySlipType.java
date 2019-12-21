package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.slip.lookup;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.EmployeeBasicSalary;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.slip.EmployeeSalrySlip;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "salary_slip_lookup")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class SalarySlipType extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "slip_type" , nullable = false)
    private String slipType;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "salarySlipType")
    private List<EmployeeSalrySlip> employeeSalrySlips;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "salarySlipType")
    private List<EmployeeBasicSalary> employeeBasicSalaries;
}
