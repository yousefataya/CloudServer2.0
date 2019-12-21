package com.experts.core.biller.statemachine.api.model.domain.jpa.inventory.catalogue.Items;

import com.experts.core.biller.statemachine.api.model.domain.jpa.inventory.InventoryInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.inventory.catalogue.Items.lookup.CatogryItemLookup;
import com.experts.core.biller.statemachine.api.model.domain.jpa.managements.organization.OrganizationDetails;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Columns;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;

@Entity
@Table(name  = "catalogue_inventory_items")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class CatalogueItem extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "item_name" , nullable = false)
    private String itemName;

    @Column(name  = "ssn" , nullable = false)
    private String ssn;

    @Column(name  = "price" , nullable = false)
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private String price;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "organization_id" , nullable = false)
    private OrganizationDetails organizationDetails;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id" , nullable = false)
    private InventoryInfo inventoryInfo;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "ctaogry_item_lookup" , nullable = false)
    private CatogryItemLookup catogryItemLookup;


    /* price reference key */

    /* organization reference key */

    /* inventory reference key */

    /* item cataogry lookup reference key  */

}