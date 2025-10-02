package com.mycompany.app;

public class User {
    private int age = 0;

    public int getAge() {
        if(this.age < 0) {
            return -1;
        }
        return this.age;
    }
}