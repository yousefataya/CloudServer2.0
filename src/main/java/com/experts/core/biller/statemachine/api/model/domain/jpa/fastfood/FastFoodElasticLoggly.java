package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name  = "fast_food_elastic_loggly")
@Data
@NoArgsConstructor
public class FastFoodElasticLoggly extends BaseEntity implements Serializable {

    @Column(name  = "uuid" , nullable = false)
    private String uuid;

    @Column(name  = "order_name" , nullable = false)
    private String orderName;

    @Column(name  = "customer_name" , nullable = false)
    private String customerName;

    @Column(name  = "customer_mobile" , nullable = false)
    private String customerMobile;

    @Column(name = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "description" , nullable = true)
    @Lob
    private String description;

    @Column(name  = "size" , nullable = false)
    private String size;

    @Column(name  = "locations" , nullable = false)
    private String locations;

    @Column(name = "number_of" , nullable = false)
    private String number;

}
