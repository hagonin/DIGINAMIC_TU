import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorParamTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void multiply_shouldReturnEvenResult_whenMultiplyingByTwo(int number) {
        int result = calculator.multiply(number, 2);
        assertEquals(0, result % 2);
        // Est ce que on test bien tous les cas de figures et que le comportement attendu fonctionne ? 
        // On test bien que le nombre sera paire (% 2 => modulo 2 => result % 2 == 0 => le reste de la division euclidienne de 
        // result par  = 0 => nombre pair)
    }

    @ParameterizedTest
    @CsvSource({
        "5, 3, 2",
        "10, 4, 6",
        "7, 7, 0"
    })
    void substract_shouldReturnExpectedResult_whenSubtracting(int a, int b, int expected) {
        int result = calculator.subtract(a, b);
        assertEquals(expected, result);
    }
}
