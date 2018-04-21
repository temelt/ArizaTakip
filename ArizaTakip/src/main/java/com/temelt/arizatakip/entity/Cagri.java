package com.temelt.arizatakip.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author taner.temel
 *
 */
@Entity
@Table(name = "arz_cagri")
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

	@Id
	@GeneratedValue(generator = "sq_cagri", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, initialValue = 100, name = "sq_cagri", sequenceName = "sq_cagri")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "baslik")
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
