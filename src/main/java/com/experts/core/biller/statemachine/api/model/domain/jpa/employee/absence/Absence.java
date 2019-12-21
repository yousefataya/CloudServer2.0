package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.lookups.AbsenceCatogry;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.policy.AbsencePolicy;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.attendance.Attendance;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.leaderships.EmployeeTeam;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.leaders.lookup.EmployeeLeaderRole;
import com.experts.core.biller.statemachine.api.model.domain.jpa.hr.engine.Branch;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name  = "hr_employee_absence")
@Data
@Builder
@Cache(region = "defaultCache" , usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Indexed
public class Absence extends BaseEntity {

    /* employee refrenece key assignTo*/

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private EmployeeInfo  employeeInfo;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "department_id" , nullable = false)
    private OrgnizationDepartment orgnizationDepartment;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_team_id" , nullable = false)
    private EmployeeTeam employeeTeam;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "branch_id" , nullable = false)
    private Branch branch;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_leadership_role" , nullable = false)
    private EmployeeLeaderRole employeeLeaderRole;

    /* employee reference key*/

    /* department reference key*/

    /* manager reference key*/

    /* branch reference key*/

    /* Team refrence key*/

    @Column(name = "description"  , nullable = true)
    private String description;

    @Column(name = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired_record" , nullable = false)
    private boolean expiredRecord;

    /* Created By*/

    /* Updated By*/

    @Column(name  = "absence_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date absenceDate;

    @Column(name  = "docs_absence" , nullable = true)
    private byte[] docs;

    /* reference key AbsenceCatogry*/

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "absence_catogry_id" , nullable = false)
    private AbsenceCatogry absenceCatogry;

    @Column(name = "deducted_days" , nullable = true)
    private int deductedDays;

    @Column(name  = "all_days" , nullable = false)
    private int allDays;


    @Column(name  = "status" , nullable = false)
    private boolean status;

    /*Workflow processEngine Id , which process in this case*/

    @Column(name  = "uuid_case" , nullable = false)
    private String uuidCase;

    @Column(name  = "runtime_case" , nullable = false)
    private String runtimeCase;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "absence_policy_id" , nullable = false)
    private AbsencePolicy absencePolicy;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "absence")
    private List<Attendance> attendanceList;
}
