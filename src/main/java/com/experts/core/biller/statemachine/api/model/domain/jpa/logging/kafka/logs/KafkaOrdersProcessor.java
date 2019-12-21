package com.experts.core.biller.statemachine.api.model.domain.jpa.logging.kafka.logs;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.CacheEvict;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "kafka_order_processors")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class KafkaOrdersProcessor extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "issue_date" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    @Column(name = "request_body" , nullable = false)
    private String request;

    @Column(name  = "response" , nullable = false)
    private String response;

    /* organization reference key */

    /* employee reference key */


}
