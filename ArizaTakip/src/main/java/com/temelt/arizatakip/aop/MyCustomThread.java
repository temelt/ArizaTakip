package com.temelt.arizatakip.aop;

public class MyCustomThread extends Thread {
	
	@Override
	public void run() {
		
		System.out.println("Thread Calisti");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread Devam etti");
		
		super.run();
	}

}
