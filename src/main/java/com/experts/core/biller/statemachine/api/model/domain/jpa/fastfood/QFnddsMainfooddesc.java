package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="q_fndds_mainfooddesc")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class QFnddsMainfooddesc extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="`End Date`")
	private Date end_Date;

	@Column(name="`Food code`")
	private int food_code;

	@Lob
	@Column(name="`Main food description`")
	private String main_food_description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="`Start Date`")
	private Date start_Date;


}
