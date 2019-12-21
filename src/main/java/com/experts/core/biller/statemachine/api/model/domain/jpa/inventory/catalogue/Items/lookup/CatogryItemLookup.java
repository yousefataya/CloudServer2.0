package com.experts.core.biller.statemachine.api.model.domain.jpa.inventory.catalogue.Items.lookup;

import com.experts.core.biller.statemachine.api.model.domain.jpa.inventory.catalogue.Items.CatalogueItem;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.CacheEvict;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "catogry_item_lookup")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class CatogryItemLookup extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired = false;

    @Column(name  = "ctaogry_value" , nullable = false)
    private String catogry;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "catogryItemLookup")
    private List<CatalogueItem> catalogueItems;

}
