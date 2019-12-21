package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "food_table")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Food implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fdc_id")
	private int fdcId;

	@Lob
	@Column(name="data_type")
	private String dataType;

	@Lob
	private String description;

	@Lob
	@Column(name="food_category_id")
	private String foodCategoryId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="publication_date")
	private Date publicationDate;


}
