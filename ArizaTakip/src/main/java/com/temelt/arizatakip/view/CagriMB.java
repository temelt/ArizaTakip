package com.temelt.arizatakip.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.temelt.arizatakip.entity.Cagri;
import com.temelt.arizatakip.service.CagriService;

@ManagedBean(name="cagriMB")
@ViewScoped
public class CagriMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2324054627791585677L;
	private CagriService cagriService =new CagriService();
	
	List<Cagri> cagriListe ;

	@PostConstruct
	private void init(){
		cagriListe = cagriService.getAll(null);
	}
	
	
	public List<Cagri> getCagriListe() {
		return cagriListe;
	}
}
