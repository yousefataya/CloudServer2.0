package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.lookups.PhoneType;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.lookups.SkypeType;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name  = "hr_employee_skype")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Skype extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "skype_value" , nullable = false)
    private String skypeValue;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo ;


    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "department_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "skype_type_id" , nullable = false)
    private SkypeType skypeType;


    /* employee reference key */

    /* skype type reference key */

    /* department reference key */


}
