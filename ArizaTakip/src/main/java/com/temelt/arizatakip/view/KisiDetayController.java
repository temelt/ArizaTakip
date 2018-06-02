package com.temelt.arizatakip.view;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.arizatakip.entity.Kisi;
import com.temelt.arizatakip.service.KisiService;

@Controller("kisiDetayController")
@Scope("view")
public class KisiDetayController implements Serializable {
	
	@Autowired
	private KisiService kisiService;

	private Kisi kisi;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 220232313132756901L;

	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
		String id = paramMap.get("id");
		if (id != null) {
			try {
				kisi = kisiService.getById(Long.parseLong(id));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Kisi getKisi() {
		return kisi;
	}
}
