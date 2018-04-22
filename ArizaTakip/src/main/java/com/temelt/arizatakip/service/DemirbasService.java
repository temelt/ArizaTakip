package com.temelt.arizatakip.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temelt.arizatakip.entity.Demirbas;

@Repository
public interface DemirbasService extends JpaRepository<Demirbas,Long> {

}
