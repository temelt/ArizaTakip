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
	
	List<Cagri> cagriListe ;

	@PostConstruct
	private void init(){
		cagriListe = cagriService.findAll();
	}
	
	
	public List<Cagri> getCagriListe() {
		return cagriListe;
	}
}
