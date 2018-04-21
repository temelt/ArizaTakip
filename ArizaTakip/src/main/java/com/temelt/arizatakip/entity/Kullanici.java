package com.temelt.arizatakip.entity;

/**
 * 
 * @author Ýrem
 *
 */
public class Kullanici extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9113248160802770476L;
	private Long id;
	private String usrnm;
	private String pwd;
	private Kisi kisi;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsrnm() {
		return usrnm;
	}

	public void setUsrnm(String usrnm) {
		this.usrnm = usrnm;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Kisi getKisi() {
		return kisi;
	}

	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}

}
