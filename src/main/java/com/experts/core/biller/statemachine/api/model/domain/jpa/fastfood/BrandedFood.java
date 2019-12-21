package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="branded_food")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class BrandedFood implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fdc_id")
	private int fdcId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="available_date")
	private Date availableDate;

	@Lob
	@Column(name="brand_owner")
	private String brandOwner;

	@Lob
	@Column(name="branded_food_category")
	private String brandedFoodCategory;

	@Lob
	@Column(name="data_source")
	private String dataSource;

	@Lob
	@Column(name="gtin_upc")
	private String gtinUpc;

	@Lob
	@Column(name="household_serving_fulltext")
	private String householdServingFulltext;

	@Lob
	private String ingredients;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_date")
	private Date modifiedDate;

	@Column(name="serving_size")
	private double servingSize;

	@Lob
	@Column(name="serving_size_unit")
	private String servingSizeUnit;

}
