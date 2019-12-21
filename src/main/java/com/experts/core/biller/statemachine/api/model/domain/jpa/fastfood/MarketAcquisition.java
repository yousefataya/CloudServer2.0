package com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="market_acquisition")
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class MarketAcquisition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fdc_id")
	private int fdcId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="acquisition_date")
	private Date acquisitionDate;

	@Lob
	@Column(name="brand_description")
	private String brandDescription;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expiration_date")
	private Date expirationDate;

	@Lob
	@Column(name="label_weight")
	private String labelWeight;

	@Lob
	private String location;

	@Lob
	@Column(name="sales_type")
	private String salesType;

	@Lob
	@Column(name="sample_lot_nbr")
	private String sampleLotNbr;

	@Lob
	@Column(name="sell_by_date")
	private String sellByDate;

	@Lob
	@Column(name="store_city")
	private String storeCity;

	@Lob
	@Column(name="store_name")
	private String storeName;

	@Lob
	@Column(name="store_state")
	private String storeState;

	@Lob
	@Column(name="upc_code")
	private String upcCode;



}
