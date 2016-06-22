package com.utkarsha.fc.util;

import com.utkarsha.fc.exception.PrimeChallengeException;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author utkarsha.padhye on 6/20/16
 */
public class IntegerInputGetter {

    public int getInput() throws PrimeChallengeException {
        System.out.println("Enter the number of prime numbers (integer) to get multiplication for");
        Scanner sc = new Scanner(System.in);
        try {
            return (Math.abs(sc.nextInt()));
        } catch (NoSuchElementException e) {
            throw new PrimeChallengeException("Invalid input, please enter a valid integer");
        }
    }
}
