package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="q_fndds_moistnfatadjust_fat")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class QFnddsMoistnfatadjustFat extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="`End Date`")
	private Date end_Date;

	@Lob
	@Column(name="`Fat Change`")
	private String fat_Change;

	@Column(name="`Food Code`")
	private int food_Code;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="`Start Date`")
	private Date start_Date;


}
