package com.temelt.arizatakip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Osman
 *
 */
@Entity
@Table(name = "arz_personel")

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

	@Id
	@GeneratedValue(generator = "sq_personel", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, initialValue = 100, name = "sq_personel", sequenceName = "sq_personel")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JoinColumn(name="kisi_id")
	@ManyToOne
	public Kisi getKisi() {
		return kisi;
	}

	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}

	@Column(name = "personel_görevi")
	public PersonelGorev getPersonelGorev() {
		return personelGorev;
	}

	public void setPersonelGorev(PersonelGorev personelGorev) {
		this.personelGorev = personelGorev;
	}

	@Column(name = "personel_maasý")
	public Double getMaas() {
		return maas;
	}

	public void setMaas(Double maas) {
		this.maas = maas;
	}

	@Column(name = "personel_sicil_no")
	public String getSicilNo() {
		return sicilNo;
	}

	public void setSicilNo(String sicilNo) {
		this.sicilNo = sicilNo;
	}

}
