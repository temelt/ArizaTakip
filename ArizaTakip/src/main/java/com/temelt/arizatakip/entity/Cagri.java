package com.temelt.arizatakip.entity;

import java.util.Date;

/**
 * 
 * @author taner.temel
 *
 */
public class Cagri extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -879403963659864786L;
	
	private Long id;
	private String baslik;
	private Date tarihi;
	private String musteri;
	private String adres;
	private String telefon;
	private String cihaz;
	private String problem;
	private Boolean sonuc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBaslik() {
		return baslik;
	}

	public void setBaslik(String baslik) {
		this.baslik = baslik;
	}

	public Date getTarihi() {
		return tarihi;
	}

	public void setTarihi(Date tarihi) {
		this.tarihi = tarihi;
	}

	public String getMusteri() {
		return musteri;
	}

	public void setMusteri(String musteri) {
		this.musteri = musteri;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getCihaz() {
		return cihaz;
	}

	public void setCihaz(String cihaz) {
		this.cihaz = cihaz;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public Boolean getSonuc() {
		return sonuc;
	}

	public void setSonuc(Boolean sonuc) {
		this.sonuc = sonuc;
	}

}
