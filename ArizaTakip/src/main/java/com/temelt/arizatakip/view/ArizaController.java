package com.temelt.arizatakip.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.arizatakip.entity.Ariza;
import com.temelt.arizatakip.entity.Personel;
import com.temelt.arizatakip.service.ArizaService;
import com.temelt.arizatakip.service.PersonelService;

@Controller("arizaController")
@Scope("session")
public class ArizaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ArizaService arizaService;
	@Autowired
	private PersonelService personelService;

	private List<Ariza> arizaListe;
	private Ariza ariza;

	@PostConstruct
	private void init() {
		arizaListe = arizaService.findAll();
		yeni();
	}
	public List<Personel> personelAcomp(String term) {
		List<Personel> liste = personelService.getBySicilNoIgnoreCaseContaining(term);
		return liste;
	}

	public void goster(Long id) {
		ariza = arizaService.findOne(id);
	}

	public void yeni() {
		ariza = new Ariza();
	}

	public void kaydet() {
		arizaService.save(ariza);
		arizaListe = arizaService.findAll();
		yeni();
	}

	public void sil(Long id) {
		arizaService.delete(id);
		arizaListe = arizaService.findAll();
	}

	public List<Ariza> getArizaListe() {
		return arizaListe;
	}

	public Ariza getAriza() {
		return ariza;
	}

	public void setAriza(Ariza ariza) {
		this.ariza = ariza;
	}
}
