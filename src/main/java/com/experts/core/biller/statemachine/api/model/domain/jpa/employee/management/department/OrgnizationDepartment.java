package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.absence.Absence;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.docs.EmployeeDocs;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.evaluations.EmployeeEvaluations;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.evaluations.tasks.EmployeeEvaluationTasks;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.experinces.EmployeeExperinces;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.holiday.EmployeeHoliday;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract.OragnizationContractDocs;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contractissuer.DepartmentContractIssuer;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.role.DepartmentRole;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.MeetingInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.room.DepartmentRooms;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.room.RoomInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.notifications.GeneralNotification;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.performance.EmployeePerfomance;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.performance.TaskIssueFaces;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.policy.EmployeeExtraPolicy;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.policy.EmployeePolicyHr;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.qualifications.EmployeeQuailification;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.resign.EmployeeResign;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.*;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.history.SalaryStatisticHistory;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.slip.EmployeeSalrySlip;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.shifiting.EmployeeTeamShifting;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.shifiting.ShiftTeamMember;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.skills.EmployeeSkills;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.transactions.EmployeeElasticLoggly;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name  = "company_departments")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class OrgnizationDepartment extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expierd" , nullable = false)
    private boolean isExpired;

    @Column(name  = "department_name" , nullable = false)
    private String deptName;

    @Column(name  = "issue_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<EmployeeSkills> employeeSkills;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<EmployeeBasicSalary> employeeBasicSalaries;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy =  "orgnizationDepartment")
    private List<Absence> absenceList;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL ,  mappedBy = "orgnizationDepartment")
    private List<EmployeeDocs> employeeDocs;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<EmployeeEvaluationTasks> employeeEvaluationTasks;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<EmployeeEvaluations> employeeEvaluations;
    /* customer conrtact reference key */
    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<EmployeeExperinces> employeeExperinces;
    /* department contract issuer */

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<EmployeeHoliday> employeeHolidays;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL ,mappedBy = "orgnizationDepartment")
    private List<OragnizationContractDocs> oragnizationContractDocs;
    /* stakeholder reference key */

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL ,mappedBy = "orgnizationDepartment")
    private List<DepartmentContractIssuer> departmentContractIssuers;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL ,mappedBy = "orgnizationDepartment")
    private List<DepartmentRole> departmentRoles;

    @Column(name  = "main_employee_department" , nullable = false)
    private String mainEmployee;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy =  "orgnizationDepartment")
    private List<RoomInfo> roomInfos;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<MeetingInfo> meetingInfos;

    /* employee reference key main person */

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<DepartmentRooms> departmentRooms;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<GeneralNotification> generalNotifications;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy =  "orgnizationDepartment")
    private List<EmployeePerfomance> employeePerfomances;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy =  "orgnizationDepartment")
    private List<TaskIssueFaces>  taskIssueFaces;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<EmployeePolicyHr> employeePolicyHrs;
    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<EmployeeExtraPolicy> employeeExtraPolicies;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<EmployeeQuailification> employeeQuailifications;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<EmployeeResign> employeeResigns;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<SalaryStatisticHistory> salaryStatisticHistories;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<EmployeeSalrySlip> employeeSalrySlips;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<EmployeeAbseence> employeeAbseences;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<EmployeeBouns> employeeBouns;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<EmployeeDeductions> employeeDeductions;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "orgnizationDepartment" ,  cascade = CascadeType.ALL)
    private List<EmployeeOverTime> employeeOverTimes;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL, mappedBy = "orgnizationDepartment")
    private List<EmployeeTeamShifting> employeeTeamShiftings;

    @OneToMany(fetch =  FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<ShiftTeamMember> shiftTeamMembers;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "orgnizationDepartment")
    private List<EmployeeElasticLoggly> employeeElasticLogglies;

}
