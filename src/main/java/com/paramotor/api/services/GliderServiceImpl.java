package com.paramotor.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paramotor.entity.Glider;
import com.paramotor.repositories.GliderRepository;

@Service
public class GliderServiceImpl implements GliderService {

    private final
    GliderRepository gliderRepository;

    @Autowired
    public GliderServiceImpl(GliderRepository gliderRepository) {
        this.gliderRepository = gliderRepository;
    }

    public long glidersCount() {
        return gliderRepository.count();
    }

    public Optional<Glider> findById(Long id) {
        return gliderRepository.findById(id);
    }

    public Glider save(Glider glider) {
        return gliderRepository.save(glider);
    }

    public Optional<Glider> findByModel(String model) {
        return gliderRepository.findByModel(model);
    }

    public ResponseEntity<String> deleteGlider(long id) {
        gliderRepository.deleteById(id);
        return new ResponseEntity<>("Glider has been deleted!", HttpStatus.OK);
    }

    public List<Glider> findAll() {
        List<Glider> gliders = new ArrayList<>();
        gliderRepository.findAll().forEach(gliders::add);
        return gliders;
    }
}
