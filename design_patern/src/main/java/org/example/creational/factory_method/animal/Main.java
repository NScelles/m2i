package org.example.creational.factory_method.animal;

public class Main {
    public static void main(String[] args) {
        new CatFactory().createAnimal().makeSound();
        Animal dog = new DogFactory().createAnimal();
        dog.makeSound();
    }
}
