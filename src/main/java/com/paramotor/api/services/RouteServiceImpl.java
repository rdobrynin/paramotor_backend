package com.paramotor.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paramotor.api.data.request.route.RouteRequestDTO;
import com.paramotor.api.data.response.json.route.RouteResponseDTO;
import com.paramotor.api.data.response.json.user.UserResponseDTO;
import com.paramotor.api.data.response.json.user.UserRoutesResponseDTO;
import com.paramotor.entity.Route;
import com.paramotor.entity.User;
import com.paramotor.repositories.RouteRepository;
import com.paramotor.repositories.UserRepository;

@Service
public class RouteServiceImpl implements RouteService {

    private final
    RouteRepository routeRepository;

    private final
    UserRepository userRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, UserRepository userRepository) {
        this.routeRepository = routeRepository;
        this.userRepository = userRepository;
    }

    public long routeCount() {
        return routeRepository.count();
    }

    public RouteResponseDTO findById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Route route = routeRepository.getOne(id);
        return modelMapper.map(route, RouteResponseDTO.class);
    }

    public RouteRequestDTO save(RouteRequestDTO routeRequestDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Route route  = modelMapper.map(routeRequestDTO, Route.class);
//        @todo Auth user
        route.setAuthor_id(-2);
        routeRepository.save(route);
        return null;
    }

    public RouteResponseDTO findByToken(String token) {
        ModelMapper modelMapper = new ModelMapper();
        Route route = routeRepository.findByToken(token);
        return modelMapper.map(route, RouteResponseDTO.class);
    }

    public ResponseEntity<String> deleteRoute(long id) {
        routeRepository.deleteById(id);
        return new ResponseEntity<>("Route has been deleted!", HttpStatus.OK);
    }

    public List<RouteResponseDTO> findAll() {
        List<Route> routes = new ArrayList<>();

        ModelMapper modelMapper = new ModelMapper();
        routeRepository.findAll().forEach(routes::add);

        List<RouteResponseDTO> routesDTO = new ArrayList<>();

        for (Route routeTemp : routes) {
            routesDTO.add(modelMapper.map(routeTemp, RouteResponseDTO.class));
        }
        return routesDTO;
    }

    public UserRoutesResponseDTO findRoutesByUser(long id) {

        ModelMapper modelMapper = new ModelMapper();
//        @todo Auth Person
//        routeRepository.findByUser("-2").forEach(routes::add);
        List<Route> routes = new ArrayList<>(routeRepository.findAll());

        List<RouteResponseDTO> routesDTO = new ArrayList<>();

        for (Route routeTemp : routes) {
            routesDTO.add(modelMapper.map(routeTemp, RouteResponseDTO.class));
        }


        User user = userRepository.getOne(id);

        UserRoutesResponseDTO userRoutesResponseDTO = new UserRoutesResponseDTO(routesDTO, modelMapper.map(user, UserResponseDTO.class));
        return userRoutesResponseDTO;

    }
}
