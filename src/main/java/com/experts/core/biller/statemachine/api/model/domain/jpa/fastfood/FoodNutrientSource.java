package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="food_nutrient_source")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage =  CacheConcurrencyStrategy.TRANSACTIONAL)
public class FoodNutrientSource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String code;

	@Lob
	private String description;

}
