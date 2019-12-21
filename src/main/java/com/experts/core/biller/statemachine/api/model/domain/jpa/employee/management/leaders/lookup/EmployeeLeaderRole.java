package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.leaders.lookup;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.Absence;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.attendance.Attendance;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.attendance.EmployeeDailyAttendance;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contract.EmployeeContract;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "employee_leader_role")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class EmployeeLeaderRole extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "role_name" , nullable = false)
    private String roleName;

    @Column(name  = "role_type" , nullable = false)
    private String roleType;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeLeaderRole")
    private List<Absence> absenceList;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeLeaderRole")
    private List<Attendance> attendances;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL ,mappedBy = "employeeLeaderRole")
    private List<EmployeeDailyAttendance> employeeDailyAttendances;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeLeaderRole")
    private List<EmployeeContract> employeeContracts;

}
