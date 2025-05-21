package org.example.structural;

import org.example.structural.decorator.pizza.CheeseDecortor;
import org.example.structural.decorator.pizza.HamDecorator;
import org.example.structural.decorator.pizza.Pizza;
import org.example.structural.decorator.pizza.PlainPizza;
import org.example.structural.decorator.text.*;

public class Main {
    public static void main(String[] args) {

        /// Pizza Exemple
//        Pizza basePizza = new PlainPizza();
//        System.out.println(basePizza.getDescription() +" " + basePizza.getCost());
//
//        Pizza cheesePizza = new CheeseDecortor(basePizza);
//        System.out.println(cheesePizza.getDescription() + " " + cheesePizza.getCost());
//
//        Pizza hamPizza = new HamDecorator(cheesePizza);
//        System.out.println(hamPizza.getDescription()+" "+hamPizza.getCost());


        /// Text Exercice
        String monText = "Mon Text";

        Text baseText = new PlainText(monText);
        System.out.println(baseText.transform());

        Text lowerText = new LowerCaseDecorator(baseText);
        System.out.println(lowerText.transform());

        Text prefixedText = new PrefixDecorator(lowerText,">> ");
        System.out.println(prefixedText.transform());

        Text upperText = new UpperCaseDecorator(prefixedText);
        System.out.println(upperText.transform());

//        baseText.setText("TEST");

        Text changedText = new ChangeTextDecorator(upperText,"New TEXT");
        System.out.println(changedText.transform());
    }
}
