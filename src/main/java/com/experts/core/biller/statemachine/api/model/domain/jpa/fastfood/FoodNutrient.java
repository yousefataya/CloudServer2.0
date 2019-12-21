package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="food_nutrient")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class FoodNutrient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private double amount;

	@Lob
	@Column(name="data_points")
	private String dataPoints;

	@Column(name="derivation_id")
	private int derivationId;

	@Column(name="fdc_id")
	private int fdcId;

	@Lob
	private String footnote;

	@Lob
	private String max;

	@Lob
	private String median;

	@Lob
	private String min;

	@Lob
	@Column(name="min_year_acquired")
	private String minYearAcquired;

	@Column(name="nutrient_id")
	private int nutrientId;



}
