package com.temelt.arizatakip.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.arizatakip.entity.Kisi;
import com.temelt.arizatakip.entity.Kullanici;
import com.temelt.arizatakip.service.KisiService;
import com.temelt.arizatakip.service.KullaniciService;

@Controller("kullaniciController")
@Scope("session")
public class KullaniciController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5980806834126346266L;
	@Autowired
	private KullaniciService kservice;
	@Autowired
	private KisiService kisiservice;
	private List<Kullanici> kullaniciL;
	private Kullanici kullanici;

	public void yeni() {
		kullanici = new Kullanici();
	}

	public Kullanici getKullanici() {
		return kullanici;
	}

	public List<Kisi> kisiAcomp(String term) {
		List<Kisi> klist = kisiservice.getByTc(term);
		return klist;
	}

	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}

	public List<Kullanici> getkullaniciL() {
		return kullaniciL;
	}

	@PostConstruct
	private void init() {
		kullaniciL = kservice.findAll();
		yeni();
	}

	public void show(Long id) {
		kullanici = kservice.findOne(id);
	}

	public void save() {
		kservice.save(kullanici);
		kullaniciL = kservice.findAll();
		yeni();
	}

	public void delete(Long id) {
		kservice.delete(id);
		kullaniciL = kservice.findAll();
	}

}
