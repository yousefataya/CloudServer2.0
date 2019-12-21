package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="food_category")
@NoArgsConstructor
@Data
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class FoodCategory  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="catogry_id")
	private int id;

	@Lob
	private String code;

	@Lob
	private String description;

}
