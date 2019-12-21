package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="q_foundation_agricultural_acquisition_nutrients")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class QFoundationNutrient extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private double amount;

	@Lob
	private String description;

	@Column(name="fdc_id")
	private int fdcId;

	@Column(name="fdc_id_of_input_food")
	private int fdcIdOfInputFood;

	@Lob
	private String name;

	@Lob
	@Column(name="unit_name")
	private String unitName;



}
