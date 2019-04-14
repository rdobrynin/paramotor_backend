package com.paramotor.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class PingController {
    @GetMapping("")
    public ResponseEntity<?> ping() {
        System.out.println("Pinging...");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
