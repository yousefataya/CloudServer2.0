package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="q_foundation_market_acquisition_components")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class QFoundationMarketComponent extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="data_points")
	private int dataPoints;

	@Lob
	private String description;

	@Column(name="fdc_id")
	private int fdcId;

	@Column(name="gram_weight")
	private double gramWeight;

	@Lob
	@Column(name="is_refuse")
	private String isRefuse;

	@Column(name="market_acquisition_fdc_id1")
	private int marketAcquisitionFdcId1;

	@Lob
	private String name;

	@Column(name="pct_weight")
	private double pctWeight;

	@Column(name="sample_food_fdc_id")
	private int sampleFoodFdcId;



}
