package com.temelt.arizatakip.entity;

import java.util.Date;

/**
 * 
 * @author Oðuz
 *
 */
public class Talep extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5665675506373288323L;
	private Long id;
	private Ariza ariza;
	private Ekipman ekipman;
	private String aciklama;
	private Date tarih;
	private Double maliyet;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ariza getAriza() {
		return ariza;
	}

	public void setAriza(Ariza ariza) {
		this.ariza = ariza;
	}

	public Ekipman getEkipman() {
		return ekipman;
	}

	public void setEkipman(Ekipman ekipman) {
		this.ekipman = ekipman;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	public Double getMaliyet() {
		return maliyet;
	}

	public void setMaliyet(Double maliyet) {
		this.maliyet = maliyet;
	}

}
