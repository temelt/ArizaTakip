package com.temelt.arizatakip.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.arizatakip.entity.Cihaz;
import com.temelt.arizatakip.service.CihazService;


@Controller("cihazConverter")
@Scope("request")
public class CihazConverter implements Converter{
	
	@Autowired
	private CihazService cihazService;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if(arg2!=null) {
			return cihazService.getOne(Long.valueOf(arg2));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 instanceof Cihaz) {
			Cihaz p = (Cihaz) arg2;
			return p.getId().toString();
		}else {
			return null;
		}
	}

}
