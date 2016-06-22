package com.utkarsha.fc;

import com.google.common.collect.Lists;
import com.utkarsha.fc.exception.PrimeChallengeException;
import com.utkarsha.fc.util.MatrixGenerator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;


/**
 * @author utkarsha.padhye on 6/21/16
 */
public class MatrixGeneratorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private MatrixGenerator underTest = new MatrixGenerator();

    @Test
    public void givenInputList_generatedMatrixIsAsExpected() throws PrimeChallengeException {
        int[][] expected = new int[][] {
                { 0, 2, 3, 5 },
                { 2, 4, 6, 10 },
                { 3, 6, 9, 15 },
                { 5, 10, 15, 25 }
        };

        int[][] actual = underTest.build2X2MultiplierMatrix(Lists.newArrayList(2, 3, 5));
        assertArrayEquals(expected, actual);
    }

    @Test
    public void givenInputListOf10PrimeNumbers_generatedMatrixIsAsExpected() throws PrimeChallengeException {
        int[][] expected = new int[][] {
                { 0, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29},
                { 2, 4, 6, 10, 14, 22, 26, 34, 38, 46, 58 },
                { 3, 6, 9, 15, 21, 33, 39, 51, 57, 69, 87  },
                { 5, 10, 15, 25, 35, 55, 65, 85, 95, 115, 145 },
                { 7, 14, 21, 35, 49, 77, 91, 119, 133, 161, 203 },
                { 11, 22, 33, 55, 77, 121, 143, 187, 209, 253, 319 },
                { 13, 26, 39, 65, 91, 143, 169, 221, 247, 299, 377 },
                { 17, 34, 51, 85, 119, 187, 221, 289, 323, 391, 493 },
                { 19, 38, 57, 95, 133, 209, 247, 323, 361, 437, 551 },
                { 23, 46, 69, 115, 161, 253, 299, 391, 437, 529, 667 },
                { 29, 58, 87, 145, 203, 319, 377, 493, 551, 667, 841 }
        };

        int[][] actual = underTest.build2X2MultiplierMatrix(Lists.newArrayList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29));
        assertArrayEquals(expected, actual);
    }

    @Test
    public void givenInputList_hasSingleElement_generatedMatrixIsAsExpected() throws PrimeChallengeException {
        int[][] expected = new int[][] {{0, 2},
                {2, 4}};

        int[][] actual = underTest.build2X2MultiplierMatrix(Lists.newArrayList(2));
        assertArrayEquals(expected, actual);
    }

    @Test
    public void givenEmptyInputList_generatedMatrixIsAsExpected() throws PrimeChallengeException {
        int[][] expected = new int[][]{{0}};

        int[][] actual = underTest.build2X2MultiplierMatrix(new ArrayList<Integer>());
        assertArrayEquals(expected, actual);
    }

    @Test
    public void givenNullInputList_generatedMatrixIsAsExpected() throws PrimeChallengeException {
        thrown.expectMessage("Error determining prime numbers to generate multiplication matrix");
        underTest.build2X2MultiplierMatrix(null);
    }
}
