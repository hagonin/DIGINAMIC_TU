package com.mycompany.app;

public class UserService {

    private final UserRepository repository;

    // Injection de dépendance
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // Je veux tester la logique de getUserAge() et non pas la logique de findById
    // Je viens donc mocker findById pour être certain qu'il me renvoie ce que je veux (données factices)
    public int getUserAge(int id) {

        // Appeler findById de mon UserRepository
        User user = repository.findById(id);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return user.getAge();
    }
}
