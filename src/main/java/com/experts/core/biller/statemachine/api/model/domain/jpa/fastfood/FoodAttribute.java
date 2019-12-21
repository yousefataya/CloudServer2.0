package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="food_attribute")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class FoodAttribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="fdc_id")
	private int fdcId;

	@Column(name="food_attribute_type_id")
	private int foodAttributeTypeId;

	@Lob
	private String name;

	@Column(name="seq_num")
	private int seqNum;

	@Lob
	private String value;

}
