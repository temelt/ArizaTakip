package com.temelt.arizatakip.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.arizatakip.entity.Cihaz;
import com.temelt.arizatakip.service.CihazService;

@Controller("cihazMB")
@Scope("session")
public class CihazMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2324054627791585677L;
	
	@Autowired
	private CihazService cihazService;	
	
	private List<Cihaz> cihazListe ;
	private Cihaz cihaz;

	@PostConstruct
	private void init(){
		cihazListe = cihazService.findAll();
		yeni();
	}	
	
	public void goster(Long id) {
		cihaz = cihazService.findOne(id);
	}
	
	public void yeni() {
		cihaz = new Cihaz();
	}
	
	public void kaydet(){
		cihazService.save(cihaz);
		cihazListe = cihazService.findAll();
		yeni();
	}
	
	public void sil(Long id){
		cihazService.delete(id);
		cihazListe = cihazService.findAll();
	}
	
	public List<Cihaz> getCihazListe() {
		return cihazListe;
	}
	
	public Cihaz getCihaz() {
		return cihaz;
	}
	
	public void setCihaz(Cihaz cihaz) {
		this.cihaz = cihaz;
	}
}
