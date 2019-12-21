package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="q_fndds_moistnfatadjust_moisture")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class QFnddsMoistnfatadjustMoisture extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="`End Date`")
	private Date end_Date;

	@Column(name="`Food Code`")
	private int food_Code;

	@Lob
	@Column(name="`Moisture Change`")
	private String moisture_Change;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="`Start Date`")
	private Date start_Date;



}
