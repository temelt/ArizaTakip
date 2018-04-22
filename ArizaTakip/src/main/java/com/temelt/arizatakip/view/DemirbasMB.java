package com.temelt.arizatakip.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.arizatakip.entity.Demirbas;
import com.temelt.arizatakip.service.DemirbasService;

@Controller("demirbasMB")
@Scope("session")
public class DemirbasMB implements Serializable {

	private static final long serialVersionUID = 565465655565558L;

	@Autowired
	private DemirbasService demirbasService;

	List<Demirbas> demirbasListe;

	@PostConstruct
	private void init() {
		demirbasListe = demirbasService.findAll();
	}

	public List<Demirbas> getDemirbasListe() {
		return demirbasListe;
	}

}
