package homework2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {


    @ParameterizedTest(name = "{0} plus {1} should be equal to {2}")
    @CsvSource({"1,2,3", "4,5,6", "7,8,9"})
    public void add_takesAplusB_returnsC(int a, int b, int c) {
        Calculator calc = new Calculator();
        int expectedResult = c;
        int result = calc.add(a, b);
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest(name = "{0} minus {1} should be equal to {2}")
    @CsvSource({"3,1,2", "4,5,-1", "7,8,9"})
    public void minus_takesAminusB_returnsC(int a, int b, int c) {
        Calculator calc = new Calculator();
        int expectedResult = c;
        int result = calc.minus(a, b);
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest(name = "{0} multiplied by {1} should be equal to {2}")
    @CsvSource({"3,1,3", "12,7,84", "7,8,9"})
    public void multiplication_takesAmultipliedByB_returnsC(int a, int b, int c) {
        Calculator calc = new Calculator();
        int expectedResult = c;
        int result = calc.multiplication(a, b);
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest(name = "{0} divided by {1} should be equal to {2}")
    @CsvSource({"3,1,3", "84,7,12", "7,8,9"})
    public void divison_takesAdividedByB_returnsC(int a, int b, int c) {
        Calculator calc = new Calculator();
        int expectedResult = c;
        int result = calc.division(a, b);
        assertEquals(expectedResult, result);
    }

    @Test
    public void divideException() throws Exception {
        Calculator calc = new Calculator();
        int a = 2;
        int b = 0;
        ArithmeticException expectedValue = new ArithmeticException("/ by zero");

        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calc.division(a,b);
        });

        String expectedMessage = "/ by zero";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}

