package org.example.creational.builder;

public class Person {
    private String firstName;
    private String lastName;
    private int age;


    public Person(int age, String lastName, String firstName) {
        this.age = age;
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
