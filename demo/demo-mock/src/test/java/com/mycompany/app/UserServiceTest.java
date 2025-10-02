package com.mycompany.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserRepository repositoryMock;
    private UserService service;

    // 2 manieres de faire : celle-ci sans l'annotation @Mock
    @BeforeEach
    void setUp() {
        repositoryMock = mock(UserRepository.class); // création du mock
        service = new UserService(repositoryMock);   // injection dans le service
    }

    @Test
    void getUserAge_returnsCorrectAge_whenUserExists() {

        User fakeUser = new User(30);
        when(repositoryMock.findById(1)).thenReturn(fakeUser);

        int age = service.getUserAge(1);

        Assertions.assertEquals(30, age);
        verify(repositoryMock, times(1)).findById(1); // vérifie l'appel
    }

    @Test
    void getUserAge_throwsException_whenUserNotFound() {

        when(repositoryMock.findById(99)).thenReturn(null); // Renvoie forcément null

        Assertions.assertThrows(IllegalArgumentException.class,() -> service.getUserAge(99));

        verify(repositoryMock, times(1)).findById(99);
    }
}

// // Deuxieme maniere 

// package com.mycompany.app;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.Assertions;

// // Dépendances pour InjectMocks et Mock
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;

// import static org.mockito.Mockito.*;

// @ExtendWith(MockitoExtension.class) // Utilise Mockito
// class UserServiceTest {

//     @Mock
//     private UserRepository repositoryMock;

//     @InjectMocks
//     private UserService service;

//     @Test
//     void getUserAge_returnsCorrectAge_whenUserExists() {

//         User fakeUser = new User(30);
//         when(repositoryMock.findById(1)).thenReturn(fakeUser);

//         int age = service.getUserAge(1);

//         Assertions.assertEquals(30, age);
//         verify(repositoryMock, times(1)).findById(1); // vérifie l'appel
//     }

//     @Test
//     void getUserAge_throwsException_whenUserNotFound() {

//         when(repositoryMock.findById(99)).thenReturn(null); // Renvoie forcément null

//         Assertions.assertThrows(IllegalArgumentException.class,() -> service.getUserAge(99));

//         verify(repositoryMock, times(1)).findById(99);
//     }
// }

