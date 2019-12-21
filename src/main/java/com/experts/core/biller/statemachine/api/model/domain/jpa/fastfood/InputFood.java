package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="input_food")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class InputFood implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String amount;

	@Column(name="fdc_id")
	private int fdcId;

	@Column(name="fdc_id_of_input_food")
	private int fdcIdOfInputFood;

	@Lob
	@Column(name="gram_weight")
	private String gramWeight;

	@Lob
	@Column(name="portion_code")
	private String portionCode;

	@Lob
	@Column(name="portion_description")
	private String portionDescription;

	@Lob
	@Column(name="retention_code")
	private String retentionCode;

	@Lob
	@Column(name="seq_num")
	private String seqNum;

	@Lob
	@Column(name="sr_code")
	private String srCode;

	@Lob
	@Column(name="sr_description")
	private String srDescription;

	@Lob
	@Column(name="survey_flag")
	private String surveyFlag;

	@Lob
	private String unit;



}
