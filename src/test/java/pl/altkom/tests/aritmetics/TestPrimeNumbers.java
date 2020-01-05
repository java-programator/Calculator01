package pl.altkom.tests.aritmetics;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pl.altkom.tests.exceptions.CalculatorException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class TestPrimeNumbers {
    private String number;
    private IntegerArithmetic sa = new IntegerArithmetic();

    public TestPrimeNumbers(String number) {
        this.number = number;
    }

    @Parameterized.Parameters
    public static Collection<String[]> createParameters() {
        List<String[]> result = new ArrayList<>();

        result.add(new String[] {"2"});
        result.add(new String[] {"3"});
        result.add(new String[] {"5"});
        return result;
    }

    @Test
    public void testPrimality() throws CalculatorException {
        Assert.assertTrue(sa.isPrime(number));
    }
}
