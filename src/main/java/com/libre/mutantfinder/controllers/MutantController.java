package com.libre.mutantfinder.controllers;

import com.libre.mutantfinder.services.MutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/mutant")
public class MutantController {

    String[] testDna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

    private MutantService mutantService;

    @Autowired
    public MutantController(MutantService mutantService){
        this.mutantService = mutantService;

    }

    @PostMapping
    public ResponseEntity isMutant(@RequestBody Map<String,String[]> dnaContainer){

        String[] dna = dnaContainer.get("dna");


        boolean result = mutantService.isMutant(dna);

        if (result){

            return ResponseEntity.ok().build();

        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

}
