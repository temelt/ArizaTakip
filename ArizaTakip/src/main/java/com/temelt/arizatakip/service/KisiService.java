package com.temelt.arizatakip.service;


import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temelt.arizatakip.entity.Kisi;

@Repository
public interface KisiService extends JpaRepository<Kisi, Long> {

	Page<Kisi> findByAdContainingIgnoreCase(String ad, Pageable pageable);



}