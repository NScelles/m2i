package org.example.structural.decorator.pizza;

public class PlainPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Pizza";
    }

    @Override
    public double getCost() {
        return 1;
    }
}
