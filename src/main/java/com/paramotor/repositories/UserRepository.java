package com.paramotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.paramotor.entity.User;

@RepositoryRestResource(collectionResourceRel = "user")
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
}