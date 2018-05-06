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
 * @author Iþýl
 *
 */
@Entity
@Table(name = "arz_kisi")
public class Kisi extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2372710385278536291L;
	private Long id;
	private String ad;
	private String soyad;
	private String telNo;
	private String adres;
	private String tc;

	@Id
	@GeneratedValue(generator = "sq_kisi", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, initialValue = 100, name = "sq_kisi", sequenceName = "sq_kisi")
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "Ad", length = 50)
	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	@Column(name = "Soyad", length = 50)
	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	@Column(name = "Adres", length = 200)
	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	@Column(name = "telNo", length = 11)
	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	@Column(name = "TC", length = 11)
	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}
	
	// Calculated Field / Transient Field
	@Transient
	public String getAdSoyad(){
		return this.ad +" "+this.soyad;
	}

}











