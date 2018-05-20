package com.temelt.arizatakip.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temelt.arizatakip.entity.Kullanici;

@Repository
public interface KullaniciService extends JpaRepository<Kullanici, Long> {
	
	Page<Kullanici> findByUsrnmContainingIgnoreCase(String usrnm, Pageable pageable);
	
	Kullanici findByUsrnm(String usrnm);
	
}
