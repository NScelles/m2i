package org.example.structural.decorator.pizza;

// pizza décorateur pour mes pizzas (ajoute du fromage)
public class CheeseDecortor extends PizzaDecorator {

    public CheeseDecortor(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " aux fromages";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.5;
    }
}
