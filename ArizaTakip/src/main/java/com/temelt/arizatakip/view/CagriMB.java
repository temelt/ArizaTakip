package com.temelt.arizatakip.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.arizatakip.entity.Cagri;
import com.temelt.arizatakip.service.CagriService;

@Controller("cagriMB")
@Scope("session")
public class CagriMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2324054627791585677L;
	
	@Autowired
	private CagriService cagriService;
	
	private List<Cagri> cagriListe ;
	private Cagri cagri;

	@PostConstruct
	private void init(){
		cagriListe = cagriService.findAll();
		yeni();
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
