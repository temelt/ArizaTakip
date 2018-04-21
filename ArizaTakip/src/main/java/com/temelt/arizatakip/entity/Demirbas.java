package com.temelt.arizatakip.entity;

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

/**
 * 
 * @author ibrahim
 *
 */
@Entity
@Table(name = "arz_demirbas")
public class Demirbas extends BaseEntity {
	
	private static final long serialVersionUID = 1979662304096095757L;
	private Long id;
	private String adi;
	private String seriNo;
	private DemirbasTipi tipi;
	private Double birimFiyat;
	private String aciklama;
	private Personel personel;

	@Id
	@GeneratedValue(generator = "sq_demirbas", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, initialValue = 100, name = "sq_demirbas", sequenceName = "sq_demirbas")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="adi",length=100)
	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	@Column(name="seri_no",length=100)
	public String getSeriNo() {
		return seriNo;
	}

	public void setSeriNo(String seriNo) {
		this.seriNo = seriNo;
	}
	
	@Column(name="demirbas_tipi")
	@Enumerated
	public DemirbasTipi getTipi() {
		return tipi;
	}

	public void setTipi(DemirbasTipi tipi) {
		this.tipi = tipi;
	}
	@Column(name="birim_fiyat")
	public Double getBirimFiyat() {
		return birimFiyat;
	}

	public void setBirimFiyat(Double birimFiyat) {
		this.birimFiyat = birimFiyat;
	}

	@Column(name="aciklama",length=300)
	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	@JoinColumn(name="personel")
	@ManyToOne
	public Personel getPersonel() {
		return personel;
	}

	public void setPersonel(Personel personel) {
		this.personel = personel;
	}

}
