package com.temelt.arizatakip.service;


import java.util.List;


import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.temelt.arizatakip.entity.Kisi;

@Repository
@Transactional
public interface KisiService extends JpaRepository<Kisi, Long> {

	Page<Kisi> findByAdContainingIgnoreCase(String ad, Pageable pageable);

	List<Kisi> getByTc(String term);

	Kisi getById(Long id);

}