package com.libre.mutantfinder.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class MutantController {

    @GetMapping
    public ResponseEntity isMutant(){
        return ResponseEntity.ok("Hello ok");
    }
}
