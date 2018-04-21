package com.temelt.arizatakip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Ýrem
 *
 */
 @Entity
 @Table(name="arz_kullanýcý")
public class Kullanici extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9113248160802770476L;
	private Long id;
	private String usrnm;
	private String pwd;
	private Kisi kisi;
@Id
@GeneratedValue(generator="seq_kullanýcý",strategy=GenerationType.SEQUENCE)
@SequenceGenerator(allocationSize=1,initialValue=100,name="seq_kullanýcý")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
@Column(name="Username")
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
