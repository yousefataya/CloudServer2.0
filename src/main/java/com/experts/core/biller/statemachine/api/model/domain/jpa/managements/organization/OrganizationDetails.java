package com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization;

import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.stakeholder.CmStakeHolderDocs;
import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.stakeholder.CrmStakeHoldrContract;
import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.stakeholder.StakeHolderMainInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Aims.Aim;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.Appointment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.appointment.attendance.Attendance;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.attendance.EmployeeDailyAttendance;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.Mobile;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.Phone;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.docs.EmployeeDocs;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.holiday.EmployeeHoliday;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.jira.projects.Project;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.branch.CompanyBranchInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract.OrganizationContract;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contractissuer.DepartmentContractIssuer;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.department.OrgnizationDepartment;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.leaders.OrganizationDepartmentLeader;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.organization.OrganizationMainInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.MeetingInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.groupmeeting.MeetingCount;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.room.DepartmentRooms;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.meeting.room.RoomInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.notifications.GeneralNotification;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.performance.EmployeePerfomance;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.policy.EmployeeExtraPolicy;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.policy.EmployeePolicyHr;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.qualifications.EmployeeQuailification;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.resign.EmployeeResign;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.*;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.history.SalaryStatisticHistory;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.salary.monthly.SalaryStatistic;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.shifiting.EmployeeTeamShifting;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.shifiting.ShiftTeamMember;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.skills.EmployeeSkills;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.transactions.EmployeeElasticLoggly;
import com.experts.core.biller.statemachine.api.model.domain.jpa.inventory.catalogue.InventoryCatalogue;
import com.experts.core.biller.statemachine.api.model.domain.jpa.inventory.catalogue.Items.CatalogueItem;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.PartenerMainInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.contact.PartnerContactInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.contact.PartnerEmail;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.contact.PartnerMobile;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.partner.contact.PartnerPhone;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.price.PriceManagement;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "organization_details")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@PrimaryKeyJoinColumn(name = "organization_id")
public class OrganizationDetails extends OrganizationMainInfo {

    /*@Column(name  = "description" , nullable = true)
    private String description;

    @Column(name = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;*/

    @Column(name  = "organization_name" , nullable = false)
    private String organizationName;

    @Column(name  = "organization_no" , nullable = false)
    private String organizationNumber;

    @Column(name  = "infp_phone" , nullable = true)
    private String infoPhone;

    @Column(name  = "info_email" , nullable = true)
    private String infoEmail;

    @Column(name  = "info_mobile" , nullable = true)
    private String infoMobile;

    @Column(name  = "post_office" , nullable = true)
    private String postOffice;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL, mappedBy = "organizationDetails")
    private List<EmployeeElasticLoggly> employeeElasticLogglies;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<EmployeeSkills> employeeSkills;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy =  "organizationDetails")
    private List<EmployeeTeamShifting> employeeTeamShiftings;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<PartenerMainInfo> partenerMainInfos;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<PartnerMobile> partnerMobiles;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<PartnerEmail> partnerEmails;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<PartnerPhone> partnerPhones;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<PartnerContactInfo> partnerContactInfos;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "organizationDetails")
    private List<PriceManagement> priceManagements;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy =  "organizationDetails")
    private List<InventoryCatalogue>  inventoryCatalogues;

    @OneToMany(fetch = FetchType.LAZY , cascade =   CascadeType.ALL , mappedBy = "organizationDetails")
    private List<CatalogueItem> catalogueItems;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "organizationDetails" , cascade =  CascadeType.ALL)
    private List<CrmStakeHoldrContract> crmStakeHoldrContracts;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<CmStakeHolderDocs> cmStakeHolderDocs;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "organizationDetails" , cascade = CascadeType.ALL)
    private List<Attendance> attendances;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<Aim> aims;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<Appointment> appointments;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<EmployeeDailyAttendance> employeeDailyAttendances;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<Mobile> mobiles;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<Phone>  phones;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<EmployeeDocs> employeeDocs;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<EmployeeHoliday> employeeHolidays;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<Project> projects;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<CompanyBranchInfo> companyBranchInfos;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<OrganizationContract> organizationContracts;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<DepartmentContractIssuer> departmentContractIssuers;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL ,mappedBy = "organizationDetails")
    private List<OrgnizationDepartment> orgnizationDepartments;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<OrganizationDepartmentLeader> organizationDepartmentLeaders;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<MeetingCount>  meetingCounts;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<DepartmentRooms> departmentRooms;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<RoomInfo> roomInfos;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<MeetingInfo> meetingInfos;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<GeneralNotification> generalNotifications;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<EmployeePerfomance> employeePerfomances;

    @OneToMany(fetch =  FetchType.LAZY , cascade = CascadeType.ALL ,mappedBy = "organizationDetails")
    private List<EmployeePolicyHr> employeePolicyHrs;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<EmployeeExtraPolicy> employeeExtraPolicies;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "organizationDetails")
    private List<EmployeeQuailification> employeeQuailifications;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<EmployeeResign> employeeResigns;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<SalaryStatisticHistory> salaryStatisticHistories;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<SalaryStatistic> salaryStatistics;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "organizationDetails")
    private List<EmployeeBasicSalary> employeeBasicSalaries;

    @OneToMany(fetch = FetchType.LAZY  , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<EmployeeAbseence> employeeAbseences;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<EmployeeBouns> employeeBouns;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL , mappedBy = "organizationDetails")
    private List<EmployeeDeductions> employeeDeductions;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<EmployeeOverTime> employeeOverTimes;

    @OneToMany(fetch = FetchType.LAZY , cascade =  CascadeType.ALL ,  mappedBy = "organizationDetails")
    private List<ShiftTeamMember> shiftTeamMembers;
    /*@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "organizationDetails")
    private List<EmployeeBasicSalary> employeeBasicSalaries;*/
}