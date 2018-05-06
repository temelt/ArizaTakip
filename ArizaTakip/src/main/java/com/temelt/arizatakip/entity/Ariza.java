package com.temelt.arizatakip.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Esra
 *
 */
@Entity
@Table
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
	
	@Id
	@GeneratedValue(generator = "sq_ariza", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, initialValue = 100, name = "sq_ariza", sequenceName = "sq_ariza")
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tarih")
	public Date getArizaTarihi() {
		return arizaTarihi;
	}

	public void setArizaTarihi(Date arizaTarihi) {
		this.arizaTarihi = arizaTarihi;
	}
	@Column(name="konu",length=2000)
	public String getKonu() {
		return konu;
	}

	public void setKonu(String konu) {
		this.konu = konu;
	}
	@Column(name="aciklama", length=300)
	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	@JoinColumn(name="personel_id")
	@ManyToOne
	public Personel getPersonel() {
		return personel;
	}

	public void setPersonel(Personel personel) {
		this.personel = personel;
	}
	@Column(name="ariza_durum")
	@Enumerated
	public ArizaDurum getArizaDurum() {
		return arizaDurum;
	}

	public void setArizaDurum(ArizaDurum arizaDurum) {
		this.arizaDurum = arizaDurum;
	}
	@Column(name="cagri")
	
	public Cagri getCagri() {
		return cagri;
	}
	
	public void setCagri(Cagri cagri) {
		this.cagri = cagri;
	}

}
