package com.temelt.arizatakip.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temelt.arizatakip.entity.Personel;

@Repository
public interface PersonelService extends JpaRepository<Personel, Long> {

	List<Personel> getBySicilNoIgnoreCaseContaining(String term);

}
