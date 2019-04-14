package com.paramotor.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paramotor.api.data.request.route.RouteRequestDTO;
import com.paramotor.api.data.response.json.route.RouteResponseDTO;
import com.paramotor.api.data.response.json.user.UserRoutesResponseDTO;
import com.paramotor.api.services.RouteService;
import com.paramotor.entity.Route;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/routes")
@CrossOrigin(origins = "http://localhost:4200")
public class RouteController {

    private RouteService routeService;

    @Autowired
    public void setRouteService(RouteService routeService) {
        this.routeService = routeService;
    }

    @ApiOperation(value = "Show full list of Routes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    @GetMapping("")
    public List<RouteResponseDTO> all() {
        System.out.println("Get all Routes...");
        return routeService.findAll();
    }

    @GetMapping("/count")
    public Long count() {
        System.out.println("Count all Routes...");
        return routeService.routeCount();
    }

    @ApiOperation(value = "Find Route by ID")
    @GetMapping("{id}")
    public RouteResponseDTO getById(@PathVariable("id") long id) {
        System.out.println("Get Route by Id...");
        return routeService.findById(id);
    }


    @ApiOperation(value = "Find Routes by User ID")
    @GetMapping("/user/{person_id}")
    public UserRoutesResponseDTO getRoutesByUser(@PathVariable("person_id") long person_id) {
        System.out.println("Get Routes by User...");
        return routeService.findRoutesByUser(person_id);
    }

    @ApiOperation(value = "Find Route by Token")
    @GetMapping("token/{token}")
    public RouteResponseDTO getByToken(@PathVariable("token") String token) {
        System.out.println("Get Route by Token...");
        return routeService.findByToken(token);
    }

    @ApiOperation(value = "Add new route")
    @PostMapping("/add")
    public ResponseEntity<?>postRoute(@RequestBody RouteRequestDTO route) {
        try {
            return new ResponseEntity<>(routeService.save(route), HttpStatus.OK);
        } catch (Exception ex) {
            String errorMessage;
            errorMessage = ex + " <== errors";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Delete route")
    @DeleteMapping("/del/{id}")
    public ResponseEntity<?> deleteRoute(@PathVariable("id") long id) {
        System.out.println("Delete Route with ID = " + id + "...");
        try {
            return new ResponseEntity<>(routeService.deleteRoute(id), HttpStatus.OK);
        } catch (Exception ex) {
            String errorMessage;
            errorMessage = ex + " <== error";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }
}
