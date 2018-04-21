package com.temelt.arizatakip.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.temelt.arizatakip.entity.Demirbas;
import com.temelt.arizatakip.service.DemirbasService;

@ManagedBean(name = "demirbasMB")
@ViewScoped
public class DemirbasMB implements Serializable {

	private static final long serialVersionUID = 565465655565558L;
	private DemirbasService demirbasService = new DemirbasService();

	List<Demirbas> demirbasListe;

	@PostConstruct
	private void init() {
		demirbasListe = demirbasService.getAll(null);
	}
	
	public List<Demirbas> getDemirbasListe(){
		return demirbasListe;
	}

}
