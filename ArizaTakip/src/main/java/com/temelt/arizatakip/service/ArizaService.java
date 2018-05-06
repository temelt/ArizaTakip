package com.temelt.arizatakip.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temelt.arizatakip.entity.Ariza;

@Repository
public interface ArizaService extends JpaRepository<Ariza, Long> {

}
