package com.paramotor.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paramotor.api.services.GliderService;
import com.paramotor.entity.Glider;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/gliders")
@CrossOrigin(origins = "http://localhost:4200")
public class GliderController {

    private GliderService gliderService;

    @Autowired
    public void setGliderService(GliderService gliderService) {
        this.gliderService = gliderService;
    }

    @ApiOperation(value = "Show full list of Gliders")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    @GetMapping("")
    public List<Glider> all() {
        System.out.println("Get all Gliders...");
        return gliderService.findAll();
    }

    @ApiOperation(value = "Find Glider by ID")
    @GetMapping("{id}")
    public Optional<Glider> getById(@PathVariable("id") long id) {
        System.out.println("Get Glider by Id...");
        return gliderService.findById(id);
    }

    @ApiOperation(value = "Find Route by entity")
    @GetMapping("model/{model}")
    public Optional<Glider> getByToken(@PathVariable("model") String model) {
        System.out.println("Get Glider by Model...");
        return gliderService.findByModel(model);
    }

    @ApiOperation(value = "Add new entity")
    @PostMapping("/add")
    public Glider postModel(@RequestBody Glider glider) {
        return gliderService.save(glider);
    }

    @ApiOperation(value = "Delete route")
    @DeleteMapping("/del")
    public ResponseEntity<String> deleteGlider(@PathVariable("id") long id) {
        System.out.println("Delete Route with ID = " + id + "...");
        return gliderService.deleteGlider(id);
    }
}
