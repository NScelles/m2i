package org.example.creational.factory_method.animal;

public class CatFactory extends AnimalFactory{
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
