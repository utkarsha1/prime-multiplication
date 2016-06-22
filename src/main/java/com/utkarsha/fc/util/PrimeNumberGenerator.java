package com.utkarsha.fc.util;

import com.google.common.collect.Lists;
import com.utkarsha.fc.exception.PrimeChallengeException;

import java.util.List;

/**
 * @author utkarsha.padhye on 6/20/16
 */
public class PrimeNumberGenerator {

    public List<Integer> getNPrimeNumbers(int n) throws PrimeChallengeException {
        int counter = 0;
        int num = 2;
        List<Integer> primeList = Lists.newArrayList();

        while (counter < n) {
            if(isPrime(num)) {
                counter++;
                primeList.add(num);
            }
            num++;
        }

        return primeList;
    }

    public boolean isPrime(int number) throws PrimeChallengeException {
        if(number == 0 || number == 1) {
            throw new PrimeChallengeException(String.format("Ambiguous Input: %s is neither prime nor composite", number));
        }

        if(number == 2) {
            return true;
        }

        for(int i = 2; i < number ; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
