package com.temelt.arizatakip.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temelt.arizatakip.entity.Kisi;
import com.temelt.arizatakip.service.KisiService;

@WebService(serviceName = "kisiWs", name = "kisiWs")
@Service
public class KisiWs {

	// Jar Generate etmek için
	// wsimport -keep -clientjar KisiWs.jar http://localhost:8081/kisiWs?wsdl
	@Autowired
	private KisiService kisiService;

	@WebMethod(operationName = "kisiGetir")
	public Kisi getKisiBilgisi(Long id) {
		Kisi k = kisiService.getById(id);
		return k;
	}
	
	@WebMethod(operationName = "kisiKaydet")
	public Boolean Kaydet(Kisi kisi) {
		kisiService.save(kisi);
		return Boolean.TRUE;
	}
	
	@WebMethod(operationName = "tumunuGetir")
	public List<Kisi> tumunuGetir() {
		return kisiService.findAll();
	}
}
