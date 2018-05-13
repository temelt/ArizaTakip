package com.temelt.arizatakip.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temelt.arizatakip.entity.Cihaz;

@Repository
public interface CihazService extends JpaRepository<Cihaz,Long> {

}
