package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.lookups;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.contact.Phone;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "phone_lookup")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class PhoneType extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "phone_type" , nullable = false)
    private String phoneType;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy =  "phoneType")
    private List<Phone> phones;

    /* employee reference key */

    /* phone type reference key */

    /* department reference key */
}
