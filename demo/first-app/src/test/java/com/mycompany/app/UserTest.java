package com.mycompany.app;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class UserTest {

    public User myUser = new User();

    @BeforeEach 
    // Tout ce qui va se passer avant chaque test

    // Tous mes tests 
    // 2 cas de figure : un cas classique et un cas "limite"

    // Doit retourner 0 comme age par défault
    @Test
    public void shouldReturnDefaultAge() {
        int result = myUser.getAge();
        assertEquals(0,result);
    }

    // public ... 
     assertThrows(MonException.class, () => {
        // ma fonction à tester qui provoque MonException
     })
    // }
}