package pl.altkom.tests;

import org.junit.Test;
import pl.altkom.tests.aritmetics.FloatArithmetic;
import pl.altkom.tests.aritmetics.IntegerArithmetic;
import pl.altkom.tests.exceptions.CalculatorException;

import static org.mockito.Mockito.*;

public class CalculatorTest {
    @Test
    public void simpleTest() throws CalculatorException {
        Calculator c = new Calculator();
        c.setFloatArithmetic(new FloatArithmetic());
        c.setIntegerArithmetic(new IntegerArithmetic());
        Input in = mock(Input.class);
        c.setIn(in);
        Output out = mock(Output.class);
        c.setOut(out);

        when(in.get()).thenReturn('2').thenReturn('+').thenReturn('2').thenReturn('=');

        c.calculateOneOperation();

        verify(out, times(1)).put('4');
        verify(out, times(1)).put('\n');
    }

    @Test
    public void exceptionServingTest() throws CalculatorException {
        Calculator c = new Calculator();
        c.setFloatArithmetic(new FloatArithmetic());
        c.setIntegerArithmetic(new IntegerArithmetic());
        Input in = mock(Input.class);
        c.setIn(in);
        Output out = mock(Output.class);
        c.setOut(out);

        when(in.get()).thenThrow(CalculatorException.class);

        c.calculateOneOperation();
    }
}