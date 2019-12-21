package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="sample_food")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class SampleFood implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fdc_id")
	private int fdcId;

}
