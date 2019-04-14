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

import com.paramotor.api.data.request.user.UserRequestDTO;
import com.paramotor.api.data.response.json.user.UserResponseDTO;
import com.paramotor.api.services.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Show full list of Users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    @GetMapping("")
    public List<UserResponseDTO> all() {
        System.out.println("Get all Users...");
        return userService.findAll();
    }

    @GetMapping("/count")
    public Long count() {
        System.out.println("Count all Users...");
        return userService.userCount();
    }

    @ApiOperation(value = "Find User by ID")
    @GetMapping("{id}")
    public UserResponseDTO getById(@PathVariable("id") long id) {
        System.out.println("Get User by Id...");
        return userService.findById(id);
    }

    @ApiOperation(value = "Add new user")
    @PostMapping("/add")
    public ResponseEntity<?> postUser(@RequestBody UserRequestDTO user) {
        try {
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        } catch (Exception ex) {
            String errorMessage;
            errorMessage = ex + " <== error";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Delete user")
    @DeleteMapping("/del/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
        System.out.println("Delete User with ID = " + id + "...");
        try {
            return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
        } catch (Exception ex) {
            String errorMessage;
            errorMessage = ex + " <== error";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }
}
