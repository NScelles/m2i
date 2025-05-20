package org.example.structural.decorator.pizza;

public class HamDecorator extends PizzaDecorator {

    public HamDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " avec du jambon";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2;
    }
}

