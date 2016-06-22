package com.utkarsha.fc.util;

import com.utkarsha.fc.exception.PrimeChallengeException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author utkarsha.padhye on 6/20/16
 */
public class MatrixGenerator {

    private static final Logger log = Logger.getLogger(MatrixGenerator.class.getName());


    public void printArray(int[][] matrix) {
        int size = matrix.length;
        for (int rowCounter = 0; rowCounter < size; rowCounter++) {
            for (int columnCounter = 0; columnCounter < size; columnCounter++) {
                System.out.print(matrix[rowCounter][columnCounter] + " ");
            }
            System.out.println();
        }

    }

    public int[][] build2X2MultiplierMatrix(List<Integer> numbers) throws PrimeChallengeException {
        if(numbers == null) {
            throw new PrimeChallengeException("Error determining prime numbers to generate multiplication matrix");
        }
        int size = numbers.size();
        int [][] multiplierArray = new int[size + 1][size + 1];

        multiplierArray[0][0] = 0;

        for(int rowCounter = 0; rowCounter < size ; rowCounter++) {
            multiplierArray[0][rowCounter + 1] = numbers.get(rowCounter);
        }

        for(int columnCounter = 0; columnCounter < size ; columnCounter++) {
            multiplierArray[columnCounter + 1][0] = numbers.get(columnCounter);
        }

        for (int rowCounter = 1; rowCounter <= size; rowCounter++) {
            for(int columnCounter = 1; columnCounter <= size; columnCounter++) {
                multiplierArray[rowCounter][columnCounter] = numbers.get(rowCounter - 1) * numbers.get(columnCounter - 1);

            }
        }
        return multiplierArray;
    }
}
