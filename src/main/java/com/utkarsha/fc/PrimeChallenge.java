package com.utkarsha.fc;

import com.utkarsha.fc.exception.PrimeChallengeException;
import com.utkarsha.fc.util.IntegerInputGetter;
import com.utkarsha.fc.util.MatrixGenerator;
import com.utkarsha.fc.util.PrimeNumberGenerator;

/**
 * @author utkarsha.padhye on 6/20/16
 */
public class PrimeChallenge {

    public static void main(String[] args) throws PrimeChallengeException {
        IntegerInputGetter integerInputGetter = new IntegerInputGetter();
        int n = integerInputGetter.getInput();
        PrimeNumberGenerator primeNumberFinder = new PrimeNumberGenerator();
        MatrixGenerator matrixGenerator = new MatrixGenerator();
        matrixGenerator.printArray(matrixGenerator.build2X2MultiplierMatrix(primeNumberFinder.getNPrimeNumbers(n)));
    }
}
