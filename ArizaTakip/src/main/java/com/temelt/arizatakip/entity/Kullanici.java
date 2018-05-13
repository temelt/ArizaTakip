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
 * @author �rem
 *
 */
@Entity
@Table(name = "arz_kullan�c�")
public class Kullanici extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9113248160802770476L;
	private Long id;
	private String usrnm;
	private Kisi kisi;
	private String pwdbir;
	private String pwdiki;
    @Id
	@GeneratedValue(generator = "seq_kullan�c�", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, initialValue = 100, name = "seq_kullan�c�")
	public Long getId(){
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "Username")
	public String getUsrnm() {
		return usrnm;
	}

	public void setUsrnm(String usrnm) {
		this.usrnm = usrnm;
	}

	@JoinColumn(name="kisi_id")
	@ManyToOne
	public Kisi getKisi() {
		return kisi;
	}

	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}
	@Column(name="�ifre")
	public String getPwdbir() {
		return pwdbir;
	}

	public void setPwdbir(String pwdbir) {
		this.pwdbir = pwdbir;
	}

	public String getPwdiki() {
		return pwdiki;
	}

	public void setPwdiki(String pwdiki) {
		this.pwdiki = pwdiki;
	}


}
