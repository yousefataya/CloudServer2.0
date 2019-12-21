package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="food_component")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class FoodComponent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="data_points")
	private int dataPoints;

	@Column(name="fdc_id")
	private int fdcId;

	@Column(name="gram_weight")
	private double gramWeight;

	@Lob
	@Column(name="is_refuse")
	private String isRefuse;

	@Column(name="min_year_acquired")
	private int minYearAcquired;

	@Lob
	private String name;

	@Column(name="pct_weight")
	private double pctWeight;


}
