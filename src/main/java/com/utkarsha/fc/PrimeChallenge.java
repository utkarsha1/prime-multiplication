package com.utkarsha.fc;

import com.utkarsha.fc.exception.PrimeChallengeException;
import com.utkarsha.fc.util.FormattedArrayPrinter;
import com.utkarsha.fc.util.IntegerInputGetter;
import com.utkarsha.fc.util.MatrixGenerator;
import com.utkarsha.fc.util.PrimeNumberGenerator;

import java.util.List;

/**
 * @author utkarsha.padhye on 6/20/16
 */
public class PrimeChallenge {

    private void generatePrimeMultiplierMatrix() throws PrimeChallengeException {
        int input = new IntegerInputGetter().getInput();
        List<Integer> primeNumbers = new PrimeNumberGenerator().getNPrimeNumbers(input);
        int[][] multiplierMatrix = new MatrixGenerator().build2X2MultiplierMatrix(primeNumbers);
        new FormattedArrayPrinter().printFormattedArray(multiplierMatrix);
    }

    public static void main(String[] args) throws PrimeChallengeException {
        new PrimeChallenge().generatePrimeMultiplierMatrix();
    }
}
