package com.temelt.arizatakip.entity;

/**
 * 
 * @author Ýbrahim
 *
 */
public class Demirbas extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1979662304096095757L;
	private Long id;
	private String adi;
	private String seriNo;
	private DemirbasTipi tipi;
	private Double birimFiyat;
	private String aciklama;
	private Personel personel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getSeriNo() {
		return seriNo;
	}

	public void setSeriNo(String seriNo) {
		this.seriNo = seriNo;
	}

	public DemirbasTipi getTipi() {
		return tipi;
	}

	public void setTipi(DemirbasTipi tipi) {
		this.tipi = tipi;
	}

	public Double getBirimFiyat() {
		return birimFiyat;
	}

	public void setBirimFiyat(Double birimFiyat) {
		this.birimFiyat = birimFiyat;
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

}
