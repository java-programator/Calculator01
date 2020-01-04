package pl.altkom.tests.aritmetics;

import org.junit.Test;
import pl.altkom.tests.StringArithmetic;
import pl.altkom.tests.exceptions.CalculatorException;

import static org.junit.Assert.*;

public class FloatArithmeticTest {
    @Test
    public void simpleTest() throws CalculatorException {
        StringArithmetic sa = new FloatArithmetic();
        assertEquals("4.0", sa.add("2", "2"));
    }
}