package com.temelt.arizatakip.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.arizatakip.entity.Personel;
import com.temelt.arizatakip.entity.Talep;
import com.temelt.arizatakip.service.PersonelService;
import com.temelt.arizatakip.service.TalepService;


@Controller("talepController")
@Scope("session")
public class TalepController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TalepService talepService;
	@Autowired
	private PersonelService personelService;
	
	private List<Talep> talepListe;
	private Talep talep;

	@PostConstruct
	private void init() {
		talepListe = talepService.findAll();
		
	}
	
	public List<Personel> personelAcomp(String term) {
		List<Personel> liste = personelService.getBySicilNoIgnoreCaseContaining(term);
		return liste;
	}
	
	public void goster(Long id) {
		talep = talepService.findOne(id);
	}
	
	public void yeni() {
		talep = new Talep();
	}
	
	public void kaydet(){
		talepService.save(talep);
		talepListe= talepService.findAll();
		yeni();
	}
	
	public void sil(Long id){
		talepService.delete(id);
		talepListe = talepService.findAll();
	}
	
	public List<Talep> getTalepListe() {
		return talepListe;
	}
	
	public Talep getTalep() {
		return talep;
	}
	
	public void setCagri(Talep talep) {
		this.talep= talep;
	}
	
	
}
