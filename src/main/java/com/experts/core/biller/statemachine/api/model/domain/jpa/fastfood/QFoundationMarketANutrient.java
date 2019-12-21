package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="q_foundation_market_acquisition_nutrients")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class QFoundationMarketANutrient  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private double amount;

	@Column(name="foundation_fdc_id")
	private int foundationFdcId;

	@Lob
	private String nutrient;

	@Lob
	@Column(name="sample_description")
	private String sampleDescription;

	@Column(name="sample_fdc_id")
	private int sampleFdcId;

	@Lob
	@Column(name="sub_sample_description")
	private String subSampleDescription;

	@Lob
	private String unit;

}
