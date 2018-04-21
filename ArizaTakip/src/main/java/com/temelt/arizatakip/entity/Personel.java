package com.temelt.arizatakip.entity;

/**
 * 
 * @author Osman
 *
 */
public class Personel extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6671809269502730623L;
	private Long id;
	private Kisi kisi;
	private PersonelGorev personelGorev;
	private Double maas;
	private String sicilNo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Kisi getKisi() {
		return kisi;
	}

	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}

	public PersonelGorev getPersonelGorev() {
		return personelGorev;
	}

	public void setPersonelGorev(PersonelGorev personelGorev) {
		this.personelGorev = personelGorev;
	}

	public Double getMaas() {
		return maas;
	}

	public void setMaas(Double maas) {
		this.maas = maas;
	}

	public String getSicilNo() {
		return sicilNo;
	}

	public void setSicilNo(String sicilNo) {
		this.sicilNo = sicilNo;
	}

}
