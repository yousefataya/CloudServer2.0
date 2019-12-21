package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="q_fndds_fnddssrlinks")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class QFnddsFnddssrlink extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Lob
	private String amount;

	@Lob
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	private Date endDate;

	@Lob
	private String expr1;

	@Column(name="food_code")
	private int foodCode;

	@Lob
	@Column(name="gram_weight")
	private String gramWeight;

	@Lob
	@Column(name="portion_code")
	private String portionCode;

	@Lob
	@Column(name="retention_code")
	private String retentionCode;

	@Lob
	@Column(name="`SR code`")
	private byte[] SR_code;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date startDate;

	@Lob
	@Column(name="survey_flag")
	private String surveyFlag;

	@Lob
	private String unit;



}
