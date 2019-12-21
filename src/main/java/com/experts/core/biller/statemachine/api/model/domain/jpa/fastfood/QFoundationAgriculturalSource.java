package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="q_foundation_agricultural_acquisition_sources")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class QFoundationAgriculturalSource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="acquisition_date")
	private Date acquisitionDate;

	@Lob
	private String description;

	@Column(name="fdc_id")
	private int fdcId;

	@Column(name="fdc_id_of_input_food")
	private int fdcIdOfInputFood;

	@Lob
	@Column(name="market_class")
	private String marketClass;

	@Lob
	private String state;

	@Lob
	private String treatment;

}
