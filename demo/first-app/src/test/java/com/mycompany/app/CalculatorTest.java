package com.mycompany.app;

import com.mycompany.app.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    static void initAll() {
        System.out.println("Starting test campaign...");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Test campaign ended.");
    }

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test ended.");
    }

    @Test
    public void testAdd() {
        assertNotNull(calculator);
        assertEquals(5, calculator.add(2, 3));
        assertEquals(3, calculator.add(-2, 5));
        assertNotEquals(6, calculator.add(2, 3));
    }

    @Test
    public void testDivide() {
        int result = calculator.divide(10, 2);
        assertTrue(result > 0);
        result = calculator.divide(-10, 2);
        assertFalse(result > 0);

        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(-6, calculator.multiply(-2, 3));
        assertEquals(0, calculator.multiply(0, 5));
    }

    @Test
    public void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(-2, calculator.subtract(3, 5));
        assertEquals(0, calculator.subtract(0, 0));
    }

    @Test
    public void testPower() {
        assertEquals(8, calculator.power(2, 3));
        assertEquals(1, calculator.power(5, 0));
        assertEquals(0, calculator.power(2, -2)); // Integer division
    }

    @Test
    public void testFailExample() {
        fail("Forced failure to observe test result.");
    }
}