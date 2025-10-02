import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void initAll() {
        System.out.println("=== Début de la campagne de tests ===");
    }

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Initialisation d’un nouveau Calculator...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Fin du test en cours.");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("=== Fin de la campagne de tests ===");
    }

    // -----------------------
    // Tests add
    // -----------------------
    @Test
    void add_returnsSum_whenAddingTwoPositiveNumbers() {
        // Given
        int a = 2, b = 3;
        // When
        int result = calculator.add(a, b);
        // Then
        assertEquals(5, result);
        assertNotNull(result);
    }

    @Test
    void add_returnsSum_whenAddingNegativeAndPositive() {
        assertEquals(3, calculator.add(-2, 5));
    }

    @Test
    void add_objectIsNotNull() {
        assertNotNull(calculator);
    }

    // -----------------------
    // Tests divide
    // -----------------------
    @Test
    void divide_returnsQuotient_whenDividingTwoPositiveNumbers() {
        int result = calculator.divide(10, 2);
        assertEquals(5, result);
        assertTrue(result > 0);
        assertFalse(result < 0);
    }

    @Test
    void divide_shouldThrowException_whenDividingByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }

    // -----------------------
    // Tests multiply
    // -----------------------
    @Test
    void multiply_returnsProduct_whenPositiveNumbers() {
        assertEquals(20, calculator.multiply(4, 5));
    }

    @Test
    void multiply_returnsNegativeProduct_whenOneOperandIsNegative() {
        assertEquals(-15, calculator.multiply(-3, 5));
    }

    @Test
    void multiply_returnsZero_whenOneOperandIsZero() {
        assertEquals(0, calculator.multiply(7, 0));
    }

    // -----------------------
    // Tests subtract
    // -----------------------
    @Test
    void subtract_returnsPositiveResult_whenFirstIsGreater() {
        assertEquals(5, calculator.subtract(10, 5));
    }

    @Test
    void subtract_returnsNegativeResult_whenFirstIsSmaller() {
        assertEquals(-8, calculator.subtract(-3, 5));
    }

    @Test
    void subtract_returnsZero_whenOperandsAreEqual() {
        assertEquals(0, calculator.subtract(7, 7));
    }

    // -----------------------
    // Tests power
    // -----------------------
    @Test
    void power_returnsCorrectResult_whenExponentIsPositive() {
        assertEquals(8, calculator.power(2, 3));
    }

    @Test
    void power_returnsOne_whenExponentIsZero() {
        assertEquals(1, calculator.power(5, 0));
    }

    @Test
    void power_returnsPositive_whenNegativeBaseAndEvenExponent() {
        assertEquals(9, calculator.power(-3, 2));
    }
}
