package com.temelt.arizatakip.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.arizatakip.entity.Demirbas;
import com.temelt.arizatakip.service.DemirbasService;
import com.temelt.arizatakip.service.PersonelService;

@Controller("demirbasController")
@Scope("session")
public class DemirbasController implements Serializable {

	private static final long serialVersionUID = 565465655565558L;

	@Autowired
	private DemirbasService demirbasService;

	@Autowired
	private PersonelService personelService;
	
	private List<Demirbas> demirbasListe;
	private Demirbas demirbas;

	@PostConstruct
	private void init() {
		demirbasListe = demirbasService.findAll();
		yeni();
	}

	public void goster(Long id) {
		demirbas = demirbasService.findOne(id);
	}

	public void yeni() {
		demirbas = new Demirbas();
	}

	public void kaydet() {
		demirbasService.save(demirbas);
		demirbasListe = demirbasService.findAll();
		yeni();
	}

	public void sil(Long id) {
		demirbasService.delete(id);
		demirbasListe = demirbasService.findAll();
	}

	public List<Demirbas> getDemirbasListe() {
		return demirbasListe;
	}
	
	public Demirbas getDemirbas() {
		return demirbas;
	}
	
	public void setDemirbas(Demirbas demirbas) {
		this.demirbas = demirbas;
	}

}
