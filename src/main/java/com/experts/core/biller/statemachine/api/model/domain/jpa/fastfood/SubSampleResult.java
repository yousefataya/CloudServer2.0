package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="sub_sample_result")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class SubSampleResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="food_nutrient_id")
	private int foodNutrientId;

	@Column(name="adjusted_amount")
	private double adjustedAmount;

	@Column(name="lab_method_id")
	private int labMethodId;

	@Lob
	@Column(name="nutrient_name")
	private String nutrientName;



}
