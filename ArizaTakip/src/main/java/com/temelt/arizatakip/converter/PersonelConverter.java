package com.temelt.arizatakip.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.arizatakip.entity.Personel;
import com.temelt.arizatakip.service.PersonelService;

@Controller("personelConverter")
@Scope("request")
public class PersonelConverter implements Converter{
	
	@Autowired
	private PersonelService personelService;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if(arg2!=null) {
			return personelService.getOne(Long.valueOf(arg2));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 instanceof Personel) {
			Personel p = (Personel) arg2;
			return p.getId().toString();
		}else {
			return null;
		}
	}

}
