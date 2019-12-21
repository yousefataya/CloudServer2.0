package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="q_foundation_market_acquisition_sources")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class QFoundationMarketSource extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="acquisition_date")
	private Date acquisitionDate;

	@Column(name="acquisition_fdc_id")
	private int acquisitionFdcId;

	@Lob
	private String city;

	@Column(name="foundation_fdc_id")
	private int foundationFdcId;

	@Lob
	@Column(name="sample_description")
	private String sampleDescription;

	@Column(name="sample_fdc_id")
	private int sampleFdcId;

	@Lob
	private String state;

}
