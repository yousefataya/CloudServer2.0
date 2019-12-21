package com.experts.core.biller.statemachine.api.model.domain.jpa.managements.price;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name  = "price_management_info")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class PriceManagement extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name = "amount" , nullable = false)
    private String amount;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_id" , nullable = false)
    private EmployeeInfo employeeInfo;



    /* organization reference key */

    /* catoloague item reference key */

    /* employee reference key */

    /* Item Size info reference key */
}
