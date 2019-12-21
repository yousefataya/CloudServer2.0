package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.leave.lookup;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.leave.EmployeeLeaveManage;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "employee_leave_lookup_hr")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class EmployeeLeaveLookup extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "leave_type" , nullable = false)
    private String leaveType;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeLeaveLookup")
    private List<EmployeeLeaveManage> employeeLeaveManages;
}
