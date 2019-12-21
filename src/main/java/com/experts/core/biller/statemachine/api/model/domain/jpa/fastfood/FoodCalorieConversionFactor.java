package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="food_calorie_conversion_factor")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class FoodCalorieConversionFactor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="food_nutrient_conversion_factor_id")
	private int foodNutrientConversionFactorId;

	@Column(name="carbohydrate_value")
	private double carbohydrateValue;

	@Column(name="fat_value")
	private double fatValue;

	@Column(name="protein_value")
	private double proteinValue;



}
