package com.paramotor.api.services;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.paramotor.entity.Glider;

public interface GliderService {

    long glidersCount();

    Optional<Glider> findById(Long Id);

    Glider save(Glider glider);

    Optional<Glider> findByModel(String model);

    ResponseEntity<String> deleteGlider(long id);

    List<Glider> findAll();
}
