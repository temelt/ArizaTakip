package com.temelt.arizatakip.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.arizatakip.entity.Kisi;
import com.temelt.arizatakip.entity.Personel;
import com.temelt.arizatakip.service.KisiService;
import com.temelt.arizatakip.service.PersonelService;


@Controller("kisiController")
@Scope("session")
public class KisiController implements Serializable{
	
	private static final long serialVersionUID = 2324054627791585677L;

	@Autowired
	private KisiService kisiService;
	
	@Autowired
	private PersonelService personelService;
	
	private List<Kisi> kisiListe ;
	private Kisi kisi;

	@PostConstruct
	private void init(){
		kisiListe = kisiService.findAll();
		yeni();
	}


	public List<Personel> personelAcomp(String term) {
		List<Personel> liste = personelService.getBySicilNoIgnoreCaseContaining(term);
		return liste;
	}
	
	public void goster(Long id) {
		kisi = kisiService.findOne(id);
	}
	
	public void yeni() {
		kisi = new Kisi();
	}
	
	public void kaydet(){
		kisiService.save(kisi);
		kisiListe = kisiService.findAll();
		yeni();
	}
	
	public void sil(Long id){
		kisiService.delete(id);
		kisiListe = kisiService.findAll();
	}
	
	public List<Kisi> getKisiListe() {
		return kisiListe;
	}
	
	public Kisi getKisi() {
		return kisi;
	}
	
	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}


}
