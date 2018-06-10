package com.temelt.arizatakip.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.temelt.arizatakip.service.KisiService;

@Service
public class TaskExecuter {

	@Autowired
	private KisiService kisiService;

	@Scheduled(initialDelay = 5000, fixedRate = 50000)
	public void sendMail() {

		System.out.println(" S�re Doldu ");
		Long count = kisiService.count();

		new MyCustomThread().start();
		
		System.out.println(" Kay�t Say�s� : " + count);

	}
	
	
	
}
