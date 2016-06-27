package com.utkarsha.fc.util;

import com.utkarsha.fc.exception.PrimeChallengeException;

import java.util.List;

/**
 * @author utkarsha.padhye on 6/20/16
 */
public class MatrixGenerator {

    public int[][] build2X2MultiplierMatrix(List<Integer> numbers) throws PrimeChallengeException {
        if(numbers == null) {
            throw new PrimeChallengeException("Error determining prime numbers to generate multiplication matrix");
        }
        int size = numbers.size();
        int [][] multiplierArray = new int[size + 1][size + 1];

        multiplierArray[0][0] = 0;

        for(int counter = 0; counter < size ; counter++) {
            int number = numbers.get(counter);
            multiplierArray[0][counter + 1] = number;
            multiplierArray[counter + 1][0] = number;
        }

        for (int rowCounter = 1; rowCounter <= size; rowCounter++) {
            for(int columnCounter = 1; columnCounter <= size; columnCounter++) {
                multiplierArray[rowCounter][columnCounter] = numbers.get(rowCounter - 1) * numbers.get(columnCounter - 1);

            }
        }
        return multiplierArray;
    }
}
