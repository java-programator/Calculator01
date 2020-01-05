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
        assertEquals("5", sa.add("4", "dupa"));
    }

    @Ignore
    @Test(timeout = 1)
    public void timeTest() {
        for (int i = 0; i < 1_000_000_000; i++) {
            int a = i * i *i;
        }
    }
}