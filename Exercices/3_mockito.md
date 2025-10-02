# Chapitre 4 – Mocking avec Mockito  
## Exercice pratique : Tester un service avec une dépendance mockée

### Étape 1 – Créer une dépendance simulée

On suppose qu’un service a besoin d’un **client externe** (exemple : une API ou un DAO).  
Créez une interface `ApiClient` dans un fichier `ApiClient.java` :

    public interface ApiClient {
        String getData();
    }

---

### Étape 2 – Créer un service qui utilise la dépendance

Créez une classe `ApiService` dans un fichier `ApiService.java` :

    public class ApiService {
        private final ApiClient client;

        public ApiService(ApiClient client) {
            this.client = client;
        }

        public String fetchUppercasedData() {
            return client.getData().toUpperCase();
        }
    }

---

### Étape 3 – Écrire un test avec Mockito

1. Créez une classe `ApiServiceTest`.  
2. Importez Mockito et JUnit :

    import static org.mockito.Mockito.*;
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.Test;

3. Écrivez un test où vous créez un **mock** de `ApiClient` et définissez son comportement avec `when(...).thenReturn(...)`.  
4. Vérifiez que le service retourne bien la donnée en majuscules.  

Exemple :

    @Test
    void shouldReturnUppercaseData() {
        ApiClient mockClient = mock(ApiClient.class);
        when(mockClient.getData()).thenReturn("hello");

        ApiService service = new ApiService(mockClient);

        assertEquals("HELLO", service.fetchUppercasedData());
        verify(mockClient, times(1)).getData();
    }

---

### Étape 4 – Expérimenter avec verify()

- Modifiez le test pour appeler deux fois `service.fetchUppercasedData()`.  
- Utilisez `verify(mockClient, times(2)).getData();` pour vérifier que le mock a bien été utilisé deux fois.  

---

### Étape 5 – Cas autonome

Ajoutez une nouvelle méthode dans `ApiService`, par exemple :

    public boolean hasData() {
        return client.getData() != null;
    }

- Écrivez vous-même les tests correspondants avec Mockito.  
- Couvrez au moins 2 cas : quand `getData()` retourne une chaîne non nulle et quand il retourne `null`.  

---

### Étape 6 – Exécution

- Compilez et exécutez vos tests.  
- Vérifiez que vos mocks et vos `verify()` fonctionnent comme prévu.  
