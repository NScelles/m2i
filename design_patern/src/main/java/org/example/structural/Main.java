package org.example.structural;

import org.example.structural.decorator.pizza.CheeseDecortor;
import org.example.structural.decorator.pizza.HamDecorator;
import org.example.structural.decorator.pizza.Pizza;
import org.example.structural.decorator.pizza.PlainPizza;
import org.example.structural.decorator.text.*;

public class Main {
    public static void main(String[] args) {

        /// Pizza Exemple
        Pizza basePizza = new PlainPizza();
        System.out.println(basePizza.getDescription() +" " + basePizza.getCost());

        Pizza cheesePizza = new CheeseDecortor(basePizza);
        System.out.println(cheesePizza.getDescription() + " " + cheesePizza.getCost());

        Pizza hamPizza = new HamDecorator(cheesePizza);
        System.out.println(hamPizza.getDescription()+" "+hamPizza.getCost());


        /// Text Exercice

        Text baseText = new PlainText();
        System.out.println(baseText.transform("Test 1"));

        Text upperText = new UpperCaseDecorator(baseText);
        System.out.println(upperText.transform("Test 2"));

        Text lowerText = new LowerCaseDecorator(baseText);
        System.out.println(lowerText.transform("Test 3"));

        Text prefixedText = new PrefixDecorator(baseText,">> ");
        System.out.println(prefixedText.transform("Test 4"));
    }
}
