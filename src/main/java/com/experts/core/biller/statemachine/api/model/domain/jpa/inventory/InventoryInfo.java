package com.experts.core.biller.statemachine.api.model.domain.jpa.inventory;

import com.experts.core.biller.statemachine.api.model.domain.jpa.inventory.catalogue.InventoryCatalogue;
import com.experts.core.biller.statemachine.api.model.domain.jpa.inventory.catalogue.Items.CatalogueItem;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "inventory_info")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class InventoryInfo extends BaseEntity {

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "notes", nullable = true)
    private String notes;

    @Column(name = "expired", nullable = false)
    private boolean isExpired = false;

    @Column(name = "inventory_name", nullable = false)
    private String inventoryName;

    @Column(name = "info_phone", nullable = true)
    private String infoPhone;

    @Column(name = "info_email", nullable = true)
    private String infoEmail;

    @Column(name = "info_mobile", nullable = true)
    private String infoMobile;

    @Column(name = "post_office", nullable = true)
    private String postOffice;

    @Column(name = "official_name", nullable = false)
    private String officialName;

    @Column(name = "main_branch_name", nullable = false)
    private String mainBranchName;

    @Column(name = "street_name", nullable = false)
    private String streetName;

    @Column(name = "building_no", nullable = false)
    private String buildingNo;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @Column(name = "country_name", nullable = true)
    private String countryName;

    @Column(name = "place", nullable = false)
    private String place;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "inventoryInfo", cascade = CascadeType.ALL)
    private List<InventoryCatalogue> inventoryCatalogues;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "inventoryInfo")
    private List<CatalogueItem> catalogueItems;

}