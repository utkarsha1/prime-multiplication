package com.utkarsha.fc.util;

import com.utkarsha.fc.exception.PrimeChallengeException;

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
        int [][] multiplierArray = new int[size][size];

        for (int rowCounter = 0; rowCounter < size; rowCounter++) {
            for(int columnCounter = 0; columnCounter < size; columnCounter++) {
                if(rowCounter == 0) {
                    multiplierArray[rowCounter][columnCounter] = numbers.get(columnCounter);
                } else if(columnCounter == 0) {
                    multiplierArray[rowCounter][columnCounter] = numbers.get(rowCounter);
                }
                else {
                    multiplierArray[rowCounter][columnCounter] = numbers.get(rowCounter) * numbers.get(columnCounter);
                }
            }
        }
        return multiplierArray;
    }
}
