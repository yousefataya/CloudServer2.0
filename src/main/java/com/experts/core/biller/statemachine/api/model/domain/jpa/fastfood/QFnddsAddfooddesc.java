package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="q_fndds_addfooddesc")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class QFnddsAddfooddesc extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Lob
	@Column(name="`Additional Description`")
	private String additional_Description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="`End date`")
	private Date end_date;

	@Column(name="`Food code`")
	private int food_code;

	@Column(name="`Seq num`")
	private int seq_num;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="`Start date`")
	private Date start_date;



}
