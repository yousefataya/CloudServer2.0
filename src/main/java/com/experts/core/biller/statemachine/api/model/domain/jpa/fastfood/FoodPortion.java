package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="food_portion")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class FoodPortion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private double amount;

	@Column(name="data_points")
	private int dataPoints;

	@Column(name="fdc_id")
	private int fdcId;

	@Lob
	private String footnote;

	@Column(name="gram_weight")
	private double gramWeight;

	@Column(name="measure_unit_id")
	private int measureUnitId;

	@Lob
	@Column(name="min_year_acquired")
	private String minYearAcquired;

	private String modifier;

	@Column(name="portion_description")
	private String portionDescription;

	@Lob
	@Column(name="seq_num")
	private String seqNum;



}
