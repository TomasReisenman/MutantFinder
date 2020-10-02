package com.libre.mutantfinder.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class MutantService {

    @Value("${app.sequence.length}")
    private Integer maxSequence;

    @Value("${app.minimum.sequence.number}")
    private Integer sequencesNeeded;

    public boolean isMutant(String[] dna){

        int foundSequences = 0;
        int row = 0;
        int column = 0;


        while (foundSequences < 2 && row < dna.length){
            while (foundSequences < 2 && column < dna[0].length()) {
                if (checkVertical(row, column, dna))
                    foundSequences++;
                if (checkHorizontal(row, column, dna))
                    foundSequences++;
                if (checkDiagonal(row, column, dna))
                    foundSequences++;
                column ++;
            }
            column = 0;
            row ++;
        }

        return foundSequences >= sequencesNeeded;

    }



    private boolean checkVertical(int row,int column,String[] dna){

        char checkChar = dna[row].charAt(column);

        if (dna.length  - row < maxSequence) {
            return false;
        }

        return IntStream.range(1,maxSequence)
                .allMatch(x ->dna[row + x].charAt(column) == checkChar );
    }


    private boolean checkHorizontal(int row,int column,String[] dna) {

        char checkChar = dna[row].charAt(column);

        if (dna.length  - column < maxSequence) {
            return false;
        }

        return IntStream.range(1,maxSequence)
                .allMatch(x ->dna[row].charAt(column + x) == checkChar);
    }
    private boolean checkDiagonal(int row,int column,String[] dna) {

        char checkChar = dna[row].charAt(column);

        if ((dna.length  - column < maxSequence) || (dna.length  - row < maxSequence)) {
            return false;
        }
        return IntStream.range(1,maxSequence)
                .allMatch(x ->dna[row + x].charAt(column + x) == checkChar );
    }
}
