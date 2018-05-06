package com.temelt.arizatakip.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Oðuz
 *
 */
@Entity
@Table(name = "talep")
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

	
	@Id
	@GeneratedValue(generator = "sq_talep", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, initialValue = 100, name = "sq_talep", sequenceName = "sq_talep")
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "ariza", length = 50)
	public Ariza getAriza() {
		return ariza;
	}

	public void setAriza(Ariza ariza) {
		this.ariza = ariza;
	}
	@Column(name = "ekipman", length = 20)
	public Ekipman getEkipman() {
		return ekipman;
	}

	public void setEkipman(Ekipman ekipman) {
		this.ekipman = ekipman;
	}
	@Column(name = "açýklama", length = 500)
	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tarih")
	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
	@Column(name = "maliyet")
	public Double getMaliyet() {
		return maliyet;
	}

	public void setMaliyet(Double maliyet) {
		this.maliyet = maliyet;
	}

}
