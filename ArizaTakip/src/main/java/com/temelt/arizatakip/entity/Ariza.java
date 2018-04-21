package com.temelt.arizatakip.entity;

import java.util.Date;

/**
 * 
 * @author Esra
 *
 */
public class Ariza extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9197874349464789315L;
	
	private Long id;
	private Date arizaTarihi;
	private String konu;
	private String aciklama;
	private Personel personel;
	private Cagri cagri;
	private ArizaDurum arizaDurum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getArizaTarihi() {
		return arizaTarihi;
	}

	public void setArizaTarihi(Date arizaTarihi) {
		this.arizaTarihi = arizaTarihi;
	}

	public String getKonu() {
		return konu;
	}

	public void setKonu(String konu) {
		this.konu = konu;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public Personel getPersonel() {
		return personel;
	}

	public void setPersonel(Personel personel) {
		this.personel = personel;
	}

	public ArizaDurum getArizaDurum() {
		return arizaDurum;
	}

	public void setArizaDurum(ArizaDurum arizaDurum) {
		this.arizaDurum = arizaDurum;
	}
	
	public Cagri getCagri() {
		return cagri;
	}
	
	public void setCagri(Cagri cagri) {
		this.cagri = cagri;
	}

}
