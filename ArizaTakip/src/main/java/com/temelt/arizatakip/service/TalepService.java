package com.temelt.arizatakip.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temelt.arizatakip.entity.Talep;

public interface TalepService extends JpaRepository<Talep, Long> {

}
