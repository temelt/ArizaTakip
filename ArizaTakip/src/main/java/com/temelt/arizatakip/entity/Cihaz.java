package com.temelt.arizatakip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author jann
 *
 */
@Entity
@Table(name = "arz_cihaz")
public class Cihaz extends BaseEntity {
	
	private static final long serialVersionUID = 1979662304096095757L;
	private Long id;
	private String adi;
	private String seriNo;
	private CihazTipi tipi;
	private Double cihazfiyati;
	private Double cihazomru;
	private String cihazkullanimi;
	private Double yipranmaorani;	
	
	@Id
	@GeneratedValue(generator = "sq_cihaz", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, initialValue = 100, name = "sq_cihaz", sequenceName = "sq_cihaz")
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "adi", length = 50)
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	@Column(name = "seri_no", length = 300)
	public String getSeriNo() {
		return seriNo;
	}
	public void setSeriNo(String seriNo) {
		this.seriNo = seriNo;
	}
	@Column(name = "cihaztipi", length = 100)
	public CihazTipi getTipi() {
		return tipi;
	}
	public void setTipi(CihazTipi tipi) {
		this.tipi = tipi;
	}
	@Column(name = "cihazfiyati", length = 100)
	public Double getCihazfiyati() {
		return cihazfiyati;
	}
	public void setCihazfiyati(Double cihazfiyati) {
		this.cihazfiyati = cihazfiyati;
	}
	@Column(name = "cihazomru", length = 100)
	public Double getCihazomru() {
		return cihazomru;
	}
	public void setCihazomru(Double cihazomru) {
		this.cihazomru = cihazomru;
	}
	@Column(name = "cihazkullanimi", length = 100)
	public String getCihazkullanimi() {
		return cihazkullanimi;
	}
	public void setCihazkullanimi(String cihazkullanimi) {
		this.cihazkullanimi = cihazkullanimi;
	}
	@Column(name = "yipranmaorani", length = 100)
	public Double getYipranmaorani() {
		return yipranmaorani;
	}
	public void setYipranmaorani(Double yipranmaorani) {
		this.yipranmaorani = yipranmaorani;
	}
	
	@Column(name = "serino", length = 100)
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	// Calculated Field / Transient Field
		@Transient
		public String getCihazAdi(){
			return this.adi +" "+this.tipi;
		}

	
}
