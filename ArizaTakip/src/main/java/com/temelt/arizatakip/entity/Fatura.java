package com.temelt.arizatakip.entity;

import java.util.Date;

/**
 * 
 * @author Mustafa
 *
 */
public class Fatura extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6795533100735223337L;
//	private Long id;
	private String adSoyad;
	private String tc;
	private Ariza ariza;
	private Double toplamMaliyet;
	private Boolean odendiMi;
	private Date faturaTarihi;

/*	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}*/

	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public Ariza getAriza() {
		return ariza;
	}

	public void setAriza(Ariza ariza) {
		this.ariza = ariza;
	}

	public Double getToplamMaliyet() {
		return toplamMaliyet;
	}

	public void setToplamMaliyet(Double toplamMaliyet) {
		this.toplamMaliyet = toplamMaliyet;
	}

	public Boolean getOdendiMi() {
		return odendiMi;
	}

	public void setOdendiMi(Boolean odendiMi) {
		this.odendiMi = odendiMi;
	}

	public Date getFaturaTarihi() {
		return faturaTarihi;
	}

	public void setFaturaTarihi(Date faturaTarihi) {
		this.faturaTarihi = faturaTarihi;
	}

}
