package com.temelt.arizatakip.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 308024193313773087L;

	private Date eklenmeTarihi;
	private Boolean durum;
	private String ekleyen;
	private Date guncellemeTarihi;
	private String guncelleyen;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ekleme_tarihi")
	public Date getEklenmeTarihi() {
		return eklenmeTarihi;
	}

	public void setEklenmeTarihi(Date eklenmeTarihi) {
		this.eklenmeTarihi = eklenmeTarihi;
	}

	@Column(name = "durum")
	public Boolean getDurum() {
		return durum;
	}

	public void setDurum(Boolean durum) {
		this.durum = durum;
	}

	@Column(name = "ekleyen", length = 100)
	public String getEkleyen() {
		return ekleyen;
	}

	public void setEkleyen(String ekleyen) {
		this.ekleyen = ekleyen;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "son_guncelleme_tarihi")
	public Date getGuncellemeTarihi() {
		return guncellemeTarihi;
	}

	public void setGuncellemeTarihi(Date guncellemeTarihi) {
		this.guncellemeTarihi = guncellemeTarihi;
	}

	@Column(name = "guncelleyen", length = 100)
	public String getGuncelleyen() {
		return guncelleyen;
	}

	public void setGuncelleyen(String guncelleyen) {
		this.guncelleyen = guncelleyen;
	}

}
