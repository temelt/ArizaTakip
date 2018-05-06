package com.temelt.arizatakip.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.arizatakip.entity.Personel;
import com.temelt.arizatakip.service.PersonelService;

@Controller("personelController")
@Scope("session")
public class PersonelController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2324054627791585677L;

	@Autowired
	private PersonelService personelService;

	private List<Personel> personelListe;
	private Personel personel;

	@PostConstruct
	private void init() {
		personelListe = personelService.findAll();
		yeni();
	}

	public void goster(Long id) {
		personel = personelService.findOne(id);
	}

	public void yeni() {
		personel = new Personel();
	}

	public void kaydet() {
		personelService.save(personel);
		personelListe = personelService.findAll();
		yeni();
	}

	public void sil(Long id) {
		personelService.delete(id);
		personelListe = personelService.findAll();
	}

	public List<Personel> getPersonelListe() {
		return personelListe;
	}

	public Personel getPersonel() {
		return personel;
	}

	public void setPersonel(Personel personel) {
		this.personel = personel;
	}
}
