# Chapitres 1 & 2 – Notions générales et Découverte de JUnit  
## Exercice pratique : Classe `Calculator` et tests unitaires avec JUnit

### Étape 0 – Créer le projet avec mvn

### Étape 1 – Créer la classe `Calculator`

Implémentez une classe `Calculator` avec les méthodes suivantes dans un fichier `Calculator.java` :

    public class Calculator {
        public int add(int a, int b) { 
            // TODO: retourner la somme
        }

        public int divide(int a, int b) { 
            // TODO: retourner la division (attention à la division par zéro)
        }

        public int multiply(int a, int b) { 
            // TODO: retourner le produit
        }

        public int subtract(int a, int b) { 
            // TODO: retourner la soustraction
        }

        public int power(int a, int b) { 
            // TODO: retourner a puissance b
        }
    }

---

### Étape 2 – Écrire les premiers tests JUnit

Créez une classe de test `CalculatorTest` dans un fichier `CalculatorTest.java`.  
Importez les assertions avec :

    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.Test;

#### Partie guidée (les 2 premières méthodes)

- Méthode `add`  
  - Cas : `add(2, 3) = 5`  
  - Cas : `add(-2, 5) = 3`  

- Méthode `divide`  
  - Cas : `divide(10, 2) = 5`  
  - Cas : division par zéro doit lever `ArithmeticException`.  

#### Partie autonome (les 3 autres méthodes)

- Choisissez au moins 3 cas de test par méthode (`multiply`, `subtract`, `power`).  
- Pensez à couvrir :  
  - un cas normal,  
  - un cas avec des valeurs négatives,  
  - un ou plusieurs cas particuliers (ex. `power(a, 0)`, `multiply(a, 0)`, etc.).  

---

### Étape 3 – Utiliser les annotations JUnit

Modifiez votre classe de test pour utiliser les annotations principales de JUnit :

    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.AfterEach;
    import org.junit.jupiter.api.BeforeAll;
    import org.junit.jupiter.api.AfterAll;

- Ajoutez un attribut `Calculator calculator;` dans la classe de test.  
- Utilisez `@BeforeEach` pour initialiser `calculator` avant chaque test.  
- Utilisez `@AfterEach` pour afficher un message en console à la fin de chaque test.  
- Ajoutez `@BeforeAll` et `@AfterAll` pour afficher un message en début et en fin de campagne de tests.  

---

### Étape 4 – Explorer les assertions JUnit (bonus)

Ajoutez de nouveaux tests ou enrichissez ceux existants en utilisant différentes assertions :  

- `assertEquals` et `assertNotEquals` avec `add`.  
- `assertTrue` et `assertFalse` avec `divide` (vérifier qu’un résultat est positif/négatif).  
- `assertNotNull` pour vérifier que l’objet `calculator` est bien instancié.  
- `assertThrows` pour la division par zéro.  
- `fail("message")` pour forcer l’échec d’un test et observer le résultat.  

---

### Étape 5 – Exécution

- Compilez vos classes et exécutez vos tests avec JUnit.  
- Observez l’ordre d’exécution des méthodes annotées (`@BeforeAll`, `@BeforeEach`, etc.).  
- Vérifiez que tous les tests passent (sauf celui volontaire avec `fail`).  
- Commentez le test en échec et relancez pour revenir au vert.  
