package pl.altkom.tests.aritmetics;

import org.junit.*;
import pl.altkom.tests.StringArithmetic;
import pl.altkom.tests.exceptions.CalculatorException;

import static org.junit.Assert.*;

public class IntegerArithmeticTest {
    static StringArithmetic sa;

    @BeforeClass
    public static void specialPrepare() {
        sa = new IntegerArithmetic();
    }

    @Test
    public void simpleTest() throws CalculatorException {
        assertEquals("Dodawanie", "4", sa.add("2", "2"));
    }

    @Test
    public void subTest() throws CalculatorException {
        assertEquals("Odejmowanie", "2", sa.sub("4", "2"));
    }

    @Test(expected = CalculatorException.class)
    public void subTest2() throws CalculatorException {
        assertEquals("Odejmowanie", "2", sa.sub("4", "test"));
    }

    @Test
    public void subTestNegative() throws CalculatorException{
        assertEquals("-5", sa.sub("-3", "2"));
    }

    @Test
    public void subTestNegativeAsSecond() throws CalculatorException{
        assertEquals("-5",sa.sub("-8","-3"));
    }

    @Test(expected = CalculatorException.class)
    public void testPersing() throws CalculatorException {
        assertEquals("5", sa.add("4", "test"));
    }

    @Test(expected = CalculatorException.class)
    public void testPersing2() throws CalculatorException {
        sa.add("test", "4");
    }

    @Ignore
    @Test
    public void testAddBigNumber1() throws CalculatorException {
        assertEquals("4000000000", sa.add("2000000000", "2000000000"));
    }

    @Ignore
    @Test(timeout = 1)
    public void timeTest() {
        for (int i = 0; i < 1_000_000_000; i++) {
            int a = i * i *i;
        }
    }

    @Test
    public void testPrimeNumbers() throws CalculatorException {
        assertTrue(sa.isPrime("2"));
    }

    @Test
    public void testNotPrimeNumbers() throws CalculatorException {
        assertFalse(sa.isPrime("4"));
        assertFalse(sa.isPrime("6"));
        assertFalse(sa.isPrime("8"));
        assertFalse(sa.isPrime("9"));
    }
}