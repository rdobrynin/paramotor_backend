package com.paramotor.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.paramotor.entity.Glider;

@RepositoryRestResource(collectionResourceRel = "route")
public interface GliderRepository extends JpaRepository<Glider, Long> {
    List<Glider> findAll();

    Optional<Glider> findByModel(@Param("entity") String token);
}