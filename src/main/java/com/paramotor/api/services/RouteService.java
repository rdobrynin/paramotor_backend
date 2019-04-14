package com.paramotor.api.services;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.paramotor.api.data.request.route.RouteRequestDTO;
import com.paramotor.api.data.response.json.route.RouteResponseDTO;
import com.paramotor.api.data.response.json.user.UserRoutesResponseDTO;

public interface RouteService {

    long routeCount();

    RouteResponseDTO findById(Long Id);

    RouteRequestDTO save(RouteRequestDTO route);

    RouteResponseDTO findByToken(String token);

    ResponseEntity<String> deleteRoute(long id);

    List<RouteResponseDTO> findAll();

    UserRoutesResponseDTO findRoutesByUser(long id);
}
