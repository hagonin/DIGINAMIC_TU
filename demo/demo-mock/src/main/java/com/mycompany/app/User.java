package com.mycompany.app;

public class User {
    private int age = 0;

    public User(int age) {
        this.age = age;
    }

    public int getAge() {
        if(this.age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
