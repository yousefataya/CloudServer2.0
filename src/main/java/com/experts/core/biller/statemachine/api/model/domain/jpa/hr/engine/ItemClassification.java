package com.experts.core.biller.statemachine.api.model.domain.jpa.hr.engine;

import com.experts.core.biller.statemachine.api.model.domain.jpa.AbstractEntity;
import com.experts.core.biller.statemachine.api.model.domain.jpa.UsersCore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name  = "store_item_classification")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Cache(usage =  CacheConcurrencyStrategy.TRANSACTIONAL , region = "com.experts.core.biller.statemachine.api.model.domain.jpa.hr.engine.ItemClassification")
public class ItemClassification extends AbstractEntity implements Serializable {


    @Column(name  = "item_color" , nullable = false)
    private String color;

    @Column(name  = "item_size" , nullable = false)
    private String size;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "description" , nullable = true)
    private String description;


    @LastModifiedDate
    private Date creationDate;

    @LastModifiedBy
    private UsersCore usersCore;

    @Version
    private int version;


    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id" , nullable = false)
    private Items items;


}
