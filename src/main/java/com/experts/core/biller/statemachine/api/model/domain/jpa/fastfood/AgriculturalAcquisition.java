package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="agricultural_acquisition")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class AgriculturalAcquisition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fdc_id")
	private int fdcId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="acquisition_date")
	private Date acquisitionDate;

	@Lob
	@Column(name="market_class")
	private String marketClass;

	@Lob
	private String state;

	@Lob
	private String treatment;



}
