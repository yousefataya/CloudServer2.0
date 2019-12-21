package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.lookups.MobileType;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name  = "hr_employee_mobile")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Mobile extends BaseEntity {

     @Column(name  = "description" , nullable = true)
     private String description;

     @Column(name  = "notes" , nullable = true)
     private String notes;

     @Column(name  = "mobile_no" , nullable = false)
     private String mobileNo;

     @Column(name  = "expired" , nullable = false)
     private boolean isExpired;

     /* employee reference key */

    /*  department reference key */

    /* Mobile Type reference key  */

    @Column(name  = "contact_time" , nullable = false)
    private String contactTime;

    @Column(name  = "backup_mobile" , nullable = true)
    private String backUpMobile;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo ;


    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "department_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "mobile_type_id" , nullable = false)
    private MobileType mobileType;
}
