package com.paramotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.paramotor.entity.Route;

@RepositoryRestResource(collectionResourceRel = "route")
public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findAll();

    Route findByToken(@Param("token") String token);
    @Query("select r from Route r where r.author_id = :author_id")
    List<Route> findByUser(@Param("author_id") String author_id);
}