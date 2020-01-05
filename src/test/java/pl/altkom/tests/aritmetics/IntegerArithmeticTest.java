package pl.altkom.tests.aritmetics;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import pl.altkom.tests.Calculator;
import pl.altkom.tests.StringArithmetic;
import pl.altkom.tests.exceptions.CalculatorException;

import static org.junit.Assert.*;

public class IntegerArithmeticTest {
    static StringArithmetic sa;

    @BeforeClass
    public static void prepare(){
        sa = new IntegerArithmetic();
    }

    @Test (expected = CalculatorException.class)
    public void tesAdditionWithLetters() throws CalculatorException {
        assertEquals("4", sa.add("2", "dupa"));
    }

    @Test
    public void simpleTest() throws CalculatorException {
        assertEquals("4", sa.add("2", "2"));
    }

    @Test
    public void subTestNegativeAsSecond() throws CalculatorException {
        assertEquals("-5", sa.sub("-8","-3"));
    }

    @Ignore
    @Test
    public void testAddBigNumber1() throws CalculatorException {
        assertEquals("4000000000", sa.add("2000000000","2000000000"));
    }

    @Test
    public void testPrimeNumber() throws CalculatorException {
        assertTrue(sa.isPrime("2"));
        assertTrue(sa.isPrime("3"));
        assertTrue(sa.isPrime("5"));
        assertTrue(sa.isPrime("7"));
    }

    @Test
    public void testNotPrimeNumber() throws CalculatorException {
        assertFalse(sa.isPrime("4"));
        assertFalse(sa.isPrime("6"));
        assertFalse(sa.isPrime("8"));
    }


}