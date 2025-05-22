package org.example.tpperenoel;

import org.example.tpperenoel.decorator.PaintDecorator;
import org.example.tpperenoel.decorator.ToyDecorator;
import org.example.tpperenoel.factory.*;
import org.example.tpperenoel.notification.Elf;

public class Main {
    public static void main(String[] args) {
        SantaClausFactory santaClausFactory = new SantaClausFactory();
        Elf nelson = new Elf("Sans Chaise");

        santaClausFactory.addObserver(nelson);
        santaClausFactory.registerFactory("MiniCar",new MiniCarFactory());

        Toy toyUn = santaClausFactory.makeToy("MiniCar");

        toyUn.use();
        ToyDecorator paintedToy = new PaintDecorator(toyUn,"Bleu");
        System.out.println(paintedToy.getDescription());

    }
}
