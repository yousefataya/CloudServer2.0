package com.experts.core.biller.statemachine.api.model.domain.jpa.employee;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.Absence;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Aims.Aim;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Appointment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Reminder.ReminderAppointment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.attendance.Attendance;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.attendance.EmployeeDailyAttendance;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.Mobile;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.Phone;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contract.EmployeeContract;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.docs.EmployeeDocs;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.evaluations.EmployeeEvaluations;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.evaluations.tasks.EmployeeEvaluationTasks;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.experinces.EmployeeExperinces;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.holiday.EmployeeHoliday;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.leaderships.EmployeeTeamMember.EmployeeTeamMember;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.leave.EmployeeLeaveManage;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.leaders.OrganizationDepartmentLeader;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.notifications.GeneralNotification;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.performance.EmployeePerfomance;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.performance.TaskIssueFaces;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.policy.EmployeeExtraPolicy;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.policy.EmployeePolicyHr;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.qualifications.EmployeeQuailification;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.resign.EmployeeResign;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.*;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.history.SalaryStatisticHistory;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.shifiting.EmployeeTeamShifting;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.shifiting.ShiftTeamMember;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.skills.EmployeeSkills;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.transactions.EmployeeElasticLoggly;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.cash.CashMamagement;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.price.PriceManagement;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name  = "employee_info")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class EmployeeInfo extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "first_name" , nullable = false)
    private String fisrtName;

    @Column(name  = "sname" , nullable = false)
    private String sName;

    @Column(name  = "last_name" , nullable = false)
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<Absence> absenceLsit;

    /* gender reference key */

    /* martial status reference key */

    /* position reference key */

    /* Address reference key */

    /* mobile reference key */

    /* email contact reference key */

    @Column(name  = "user_name" , nullable = false)
    private String userName;

    @Column(name  = "password" , nullable = false)
    private String password;

    @Column(name  = "last_login_time" , nullable = true)
    private Date lastLoginTime;

    @Column(name  = "ssn_serial" , nullable = false)
    private String ssn;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeeElasticLoggly> employeeElasticLogglies;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL ,  mappedBy =  "employeeInfo")
    private List<EmployeeSkills> employeeSkills;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<ShiftTeamMember> shiftTeamMembers;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeeTeamShifting> employeeTeamShiftings;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeeBasicSalary> employeeBasicSalaries;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "employeeInfo")
    private List<CashMamagement> cashMamagementList;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "employeeInfo")
    private List<PriceManagement>priceManagements;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL ,mappedBy = "employeeInfo")
    private List<Attendance> attendances;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<Aim> aims;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "employeeInfo")
    private List<Appointment> appointments;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<ReminderAppointment> reminderAppointments;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeeDailyAttendance> employeeDailyAttendances;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<Mobile> mobiles;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "employeeInfo" , cascade = CascadeType.ALL)
    private List<Phone> phones;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeeContract> employeeContracts;

    @OneToMany(fetch = FetchType.LAZY ,  cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeeDocs> employeeDocs;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeeEvaluationTasks> employeeEvaluationTasks;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeeEvaluations> employeeEvaluations;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeeExperinces> employeeExperinces;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeeHoliday> employeeHolidays;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeeTeamMember> employeeTeamMembers;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeeLeaveManage> employeeLeaveManages;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "manager")
    private List<EmployeeLeaveManage> managersEmployeeLeave;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<OrganizationDepartmentLeader> organizationDepartmentLeaders;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "employeeInfo")
    private List<GeneralNotification> generalNotifications;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeePerfomance> employeePerfomances;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<TaskIssueFaces> taskIssueFaces;

    @OneToMany(fetch  = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeePolicyHr> employeePolicyHrs;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeeExtraPolicy> employeeExtraPolicies;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeeQuailification> employeeQuailifications;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeeResign> employeeResigns;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<SalaryStatisticHistory>  salaryStatisticHistories;

    /*@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeeBasicSalary> employeeBasicSalaries;*/

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeeAbseence> employeeAbseences;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL, mappedBy = "employeeInfo")
    private List<EmployeeBouns> employeeBouns;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeeDeductions> employeeDeductions;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "employeeInfo")
    private List<EmployeeOverTime> employeeOverTimes;
}
