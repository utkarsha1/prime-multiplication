package com.utkarsha.fc;
import com.google.common.collect.Lists;
import com.utkarsha.fc.exception.PrimeChallengeException;
import com.utkarsha.fc.util.PrimeNumberGenerator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * @author utkarsha.padhye on 6/20/16
 */
public class PrimeNumberGeneratorTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    private PrimeNumberGenerator underTest = new PrimeNumberGenerator();

    @Test
    public void whenInputIsZero_verifyCustomException() throws PrimeChallengeException {
        thrown.expect(PrimeChallengeException.class);
        thrown.expectMessage("Ambiguous Input: 0 is neither prime nor composite");
        underTest.isPrime(0);
    }

    @Test
    public void whenInputIsOne_verifyCustomException() throws PrimeChallengeException {
        thrown.expect(PrimeChallengeException.class);
        thrown.expectMessage("Ambiguous Input: 1 is neither prime nor composite");
        underTest.isPrime(1);
    }

    @Test
    public void whenInputIsTwo_verifyTrue() throws PrimeChallengeException {
        assertTrue(underTest.isPrime(2));
    }

    @Test
    public void whenInputIsThree_verifyTrue() throws PrimeChallengeException {
        assertTrue(underTest.isPrime(3));
    }

    @Test
    public void whenInputIsFour_verifyFalse() throws PrimeChallengeException {
        assertFalse(underTest.isPrime(4));
    }

    @Test
    public void whenInputIsThirteen_verifyTrue() throws PrimeChallengeException {
        assertTrue(underTest.isPrime(13));
    }

    @Test
    public void whenInputIsTen_verifyFalse() throws PrimeChallengeException {
        assertFalse(underTest.isPrime(10));
    }

    @Test
    public void whenInputIsLargestFourDigitPrimeNumber_verifyTrue() throws PrimeChallengeException {
        assertTrue(underTest.isPrime(8191));
    }

    @Test
    public void whenInputIsLargestSevenDigitPrimeNumber_verifyTrue() throws PrimeChallengeException {
        assertTrue(underTest.isPrime(6700417));
    }

    @Test
    public void whenGetNPrimeNumbers_andN5_returnsExpectedList() throws PrimeChallengeException {
        assertEquals(Lists.newArrayList(2, 3, 5, 7, 11) , underTest.getNPrimeNumbers(5));
    }

    @Test
    public void whenGetNPrimeNumbers_andN1_returnsExpectedList() throws PrimeChallengeException {
        assertEquals(Lists.newArrayList(2) , underTest.getNPrimeNumbers(1));
    }

    @Test
    public void whenGetNPrimeNumbers_andN0_returnsExpectedList() throws PrimeChallengeException {
        assertEquals(Lists.newArrayList() , underTest.getNPrimeNumbers(0));
    }

    @Test
    public void whenGetNPrimeNumbers_andNMinusOne_returnsExpectedList() throws PrimeChallengeException {
        assertEquals(Lists.newArrayList() , underTest.getNPrimeNumbers(-1));
    }

}