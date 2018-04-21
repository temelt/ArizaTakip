package com.temelt.arizatakip.entity;

/**
 * 
 * @author Janberk
 *
 */
public class Ekipman extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 783461058037405488L;
	private Long id;
	private String adi;
	private EkipmanKategori kategori;
	private Boolean aktif;

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

	public EkipmanKategori getKategori() {
		return kategori;
	}

	public void setKategori(EkipmanKategori kategori) {
		this.kategori = kategori;
	}

	public Boolean getAktif() {
		return aktif;
	}

	public void setAktif(Boolean aktif) {
		this.aktif = aktif;
	}

}
