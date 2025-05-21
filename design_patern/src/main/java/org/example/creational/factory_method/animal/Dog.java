package org.example.creational.factory_method.animal;

public class Dog implements Animal{
    @Override
    public void makeSound() {
        System.out.println("Wouf");
    }
}
