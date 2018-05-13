package com.temelt.arizatakip.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.arizatakip.entity.Kisi;
import com.temelt.arizatakip.service.KisiService;

@Controller("kisiConverter")
@Scope("request")
public class KisiConverter implements Converter {

	@Autowired
	private KisiService kisiService;
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
			if(arg2!=null) {
				return kisiService.getOne(Long.valueOf(arg2));
			}
			return null;
		}
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 instanceof Kisi) {
		Kisi k= (Kisi) arg2;
			return k.getId().toString();
		}else {
			return null;
		}

}
}