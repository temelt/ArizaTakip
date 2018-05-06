package com.temelt.arizatakip.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.arizatakip.entity.Cagri;
import com.temelt.arizatakip.entity.Personel;
import com.temelt.arizatakip.service.CagriService;
import com.temelt.arizatakip.service.PersonelService;

@Controller("cagriController")
@Scope("session")
public class CagriController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2324054627791585677L;
	
	@Autowired
	private CagriService cagriService;
	@Autowired
	private PersonelService personelService;
	
	private List<Cagri> cagriListe ;
	private Cagri cagri;

	@PostConstruct
	private void init(){
		cagriListe = cagriService.findAll();
		yeni();
	}
	
	public List<Personel> personelAcomp(String term) {
		List<Personel> liste = personelService.getBySicilNoIgnoreCaseContaining(term);
		return liste;
	}
	
	public void goster(Long id) {
		cagri = cagriService.findOne(id);
	}
	
	public void yeni() {
		cagri = new Cagri();
	}
	
	public void kaydet(){
		cagriService.save(cagri);
		cagriListe = cagriService.findAll();
		yeni();
	}
	
	public void sil(Long id){
		cagriService.delete(id);
		cagriListe = cagriService.findAll();
	}
	
	public List<Cagri> getCagriListe() {
		return cagriListe;
	}
	
	public Cagri getCagri() {
		return cagri;
	}
	
	public void setCagri(Cagri cagri) {
		this.cagri = cagri;
	}
}
