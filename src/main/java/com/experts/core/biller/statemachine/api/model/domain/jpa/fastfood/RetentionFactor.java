package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="retention_factor")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class RetentionFactor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private short code;

	@Lob
	private String description;

	@Column(name="food_group_id")
	private int foodGroupId;



}
