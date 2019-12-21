package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="acquisition_sample")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class AcquisitionSample implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fdc_id")
	private int fdcId;

	@Column(name="fdc_id_of_acquisition_food")
	private int fdcIdOfAcquisitionFood;

	@Column(name="fdc_id_of_sample_food")
	private int fdcIdOfSampleFood;



}
