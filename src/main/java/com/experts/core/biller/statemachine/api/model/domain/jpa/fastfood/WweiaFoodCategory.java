package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="wweia_food_category")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class WweiaFoodCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="wweia_food_category_code")
	private int wweiaFoodCategoryCode;

	@Lob
	@Column(name="wweia_food_category_description")
	private String wweiaFoodCategoryDescription;



}
