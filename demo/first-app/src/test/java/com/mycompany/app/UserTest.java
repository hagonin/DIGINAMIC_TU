package com.mycompany.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.params.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        // Given : un nouvel utilisateur
        user = new User();
    }

    @AfterEach
    void tearDown() {
        // nettoyage éventuel
        user = null;
    }

    @Test
    void getAge_returnsZero_whenUserIsNew() {
        // When
        int result = user.getAge();

        // Then
        Assertions.assertEquals(0, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 25})
    void getAge_returnsSetValue_whenAgeIsPositive(int input) {
        // Given
        user.setAge(input);

        // When
        int result = user.getAge();

        // Then
        Assertions.assertEquals(input, result);
    }

    @Test
    void getAge_throwsException_whenAgeIsNegative() {
        // Given
        user.setAge(-5);

        // When + Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> user.getAge());
    }
}
