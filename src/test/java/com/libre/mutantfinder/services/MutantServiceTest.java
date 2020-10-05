package com.libre.mutantfinder.services;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
class MutantServiceTest {

    @Value("${app.sequence.length}")
    private Integer maxSequence;

    @Value("${app.minimum.sequence.number}")
    private Integer sequencesNeeded;

    @Autowired
    private MutantService mutantService;

    @Test
    void isMutant() {

        String[] testDna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

        assertThat(mutantService.isMutant(testDna),equalTo(true));
    }
}