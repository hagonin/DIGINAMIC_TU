import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    // Une seule fois avant tous les tests
    @BeforeAll
    static void initAll() {
        System.out.println("=== Début de la campagne de tests ===");
    }

    // Avant chaque test
    @BeforeEach
    void init() {

        System.out.println("Initialisation d’un nouveau Calculator...");
    }

    // Après chaque test
    @AfterEach
    void tearDown() {
        System.out.println("Fin du test en cours.");
    }

    // Une seule fois après tous les tests
    @AfterAll
    static void tearDownAll() {
        System.out.println("=== Fin de la campagne de tests ===");
    }

    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3)); 
        assertEquals(3, calculator.add(-2, 5));  
        assertNotEquals(10, calculator.add(2, 3)); 
        assertNotNull(calculator);                
    }

    @Test
    void testDivide() {
        int result = calculator.divide(10, 2);
        assertEquals(5, result);
        assertTrue(result > 0);
        assertFalse(result < 0); 

        assertThrows(ArithmeticException.class,() -> calculator.divide(10, 0)); 
    }

    @Test
    void testMultiply() {
        assertEquals(20, calculator.multiply(4, 5));
        assertEquals(-15, calculator.multiply(-3, 5));
        assertEquals(0, calculator.multiply(7, 0));
    }

    @Test
    void testSubtract() {
        assertEquals(5, calculator.subtract(10, 5));
        assertEquals(-8, calculator.subtract(-3, 5));
        assertEquals(0, calculator.subtract(7, 7));
    }

    @Test
    void testPower() {
        assertEquals(8, calculator.power(2, 3));
        assertEquals(1, calculator.power(5, 0));
        assertEquals(9, calculator.power(-3, 2));

        // Exemple de test volontairement en échec pour observer fail()
        // fail("Test forcé en échec pour démonstration !");
    }
}
