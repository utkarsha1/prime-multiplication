package com.utkarsha.fc;

import com.utkarsha.fc.exception.PrimeChallengeException;
import com.utkarsha.fc.util.IntegerInputGetter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * @author utkarsha.padhye on 6/20/16
 */
public class IntegerInputGetterTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();
    private final IntegerInputGetter underTest = new IntegerInputGetter();

    @Test
    public void whenUserInputsStringNumber_thenReturnIntegerEquivalent() throws PrimeChallengeException {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(5, underTest.getInput());
    }

    @Test
    public void whenUserInputsWhitespace_thenReturnsAppropriateException() throws PrimeChallengeException {
        String input = "  ";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        thrown.expectMessage("Invalid input, please enter a valid integer");
        underTest.getInput();
    }

    @Test
    public void whenUserInputsDouble_thenReturnsAppropriateException() throws PrimeChallengeException {
        String input = "11.4567";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        thrown.expectMessage("Invalid input, please enter a valid integer");
        underTest.getInput();
    }

    @Test
    public void whenUserInputsString_thenReturnsAppropriateException() throws PrimeChallengeException {
        String input = "c";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        thrown.expectMessage("Invalid input, please enter a valid integer");
        underTest.getInput();
    }

    @Test
    public void whenUserInputsSpecialCharacters_thenReturnsAppropriateException() throws PrimeChallengeException {
        String input = "@#$&*%";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        thrown.expectMessage("Invalid input, please enter a valid integer");
        underTest.getInput();
    }

    @Test
    public void whenUserInputsNegativeNumber_thenReturnsAppropriateInteger() throws PrimeChallengeException {
        String input = "-5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(5, underTest.getInput());
    }

    @Test
    public void whenUserInputsLargeNegativeNumberOutsideIntegerRange_thenReturnsAppropriateException() throws PrimeChallengeException {
        String input = "-57868879998009878789";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        thrown.expectMessage("Invalid input, please enter a valid integer");
        underTest.getInput();
    }

    @Test
    public void whenUserInputsLargePositiveNumberOutsideIntegerRange_thenReturnsAppropriateException() throws PrimeChallengeException {
        String input = "78688799980098787897";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        thrown.expectMessage("Invalid input, please enter a valid integer");
        underTest.getInput();
    }

    @Test
    public void whenUserInputsMinInteger_thenReturnsCorrectValue() throws PrimeChallengeException {
        String input = "-2147483648";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(Math.abs(-2147483648), underTest.getInput());
    }

    @Test
    public void whenUserInputsMaxInteger_thenReturnsCorrectValue() throws PrimeChallengeException {
        String input = "2147483647";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(2147483647, underTest.getInput());
    }

    @Test
    public void whenUserInputsMaxIntegerWithCommas_thenReturnsCorrectValue() throws PrimeChallengeException {
        String input = "2,147,483,647";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(2147483647, underTest.getInput());
    }

    @Test
    public void whenUserInputsMinIntegerWithCommas_thenReturnsCorrectValue() throws PrimeChallengeException {
        String input = "-2,147,483,648";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(-2147483648, underTest.getInput());
    }
}
