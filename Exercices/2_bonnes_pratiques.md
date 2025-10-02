# Chapitre 3 – Organisation et bonnes pratiques  
## Exercice pratique : Améliorer l’organisation et la lisibilité des tests

### Étape 1 – Reprendre la classe `Calculator`

Réutilisez la classe `Calculator` et vos tests JUnit existants.  
Vous allez maintenant organiser et améliorer vos tests pour qu’ils soient plus clairs et maintenables.  

---

### Étape 2 – Convention de nommage

1. Vérifiez que la classe de test s’appelle bien `CalculatorTest`.  
2. Renommez vos méthodes de test pour suivre les conventions vues en cours :  
   - `methodName_expectedBehavior()`  
   - ou `shouldExpectedBehavior_whenCondition()`  
   
   Exemple :  
   - `add_returnsSum()`  
   - `shouldThrowException_whenDividingByZero()`  

---

### Étape 3 – Approche Given / When / Then

Vérifiez et tentez de comprendre l'approche *Given / When / Then*
Les tests ont surement déjà cette approche, si ce n'est pas le cas mettez la en place sur **2 tests existants**

Exemple sur l’addition :  

    @Test
    void shouldReturnCorrectSum_whenAddingTwoNumbers() {
        // Given
        Calculator calculator = new Calculator();

        // When
        int result = calculator.add(2, 3);

        // Then
        assertEquals(5, result);
    }

---

### Étape 4 – Grouper et organiser le code de test

1. Déplacez vos tests dans des **sections logiques**
Par exemple, `add` possède trois tests : un avec nombre positif, un négatif, un avec une addtion avec 0...

2. Si ce n'est pas fait, utilisez `@BeforeEach` pour initialiser un `Calculator` commun afin d’éviter la duplication de code.  

    @BeforeEach  
    void setUp() {  
        calculator = new Calculator();  
    }  

---

### Étape 5 – Tests paramétrés

1. Créez une nouvelle classe de test `CalculatorParamTest`.  
2. Ajoutez un test paramétré avec `@ParameterizedTest` et `@ValueSource` pour vérifier que la multiplication par 2 retourne toujours un nombre pair :  

    @ParameterizedTest  
    @ValueSource(ints = {2, 4, 6, 8, 10})  
    void shouldReturnEvenResult_whenMultiplyingByTwo(int number) {  
        assertEquals(0, calculator.multiply(number, 2) % 2);  
    }  

3. Ajoutez un test avec `@CsvSource` pour vérifier plusieurs combinaisons de la soustraction :  

    @ParameterizedTest  
    @CsvSource({ "5,3,2", "10,4,6", "7,7,0" })  
    void shouldReturnExpectedResult_whenSubtracting(int a, int b, int expected) {  
        assertEquals(expected, calculator.subtract(a, b));  
    }  

---

### Étape 6 – Exécution

- Relancez l’ensemble de vos tests (`CalculatorTest` + `CalculatorParamTest`).  
- Vérifiez que vos méthodes de test sont **claires, bien nommées et organisées**.  
- Comparez la lisibilité de vos tests avant et après les améliorations.  
