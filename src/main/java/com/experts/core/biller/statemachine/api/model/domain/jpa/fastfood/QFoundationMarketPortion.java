package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="q_foundation_market_acquisition_portions")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class QFoundationMarketPortion extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "acquisition_fdc_id")
	private int acquisitionFdcId;

	private double amount;

	@Column(name = "ample_fdc_id")
	private int ampleFdcId;

	@Column(name = "data_points")
	private int dataPoints;

	@Column(name = "foundation_fdc_id")
	private int foundationFdcId;

	@Column(name = "gram_weight")
	private double gramWeight;

	private String modifier;

	@Lob
	@Column(name = "sample_description")
	private String sampleDescription;

	@Lob
	private String unit;
}
