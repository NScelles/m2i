package org.example.tpperenoel.notification;

import org.example.tpperenoel.factory.Toy;

public class Elf implements Observer {

    private String name;

    public Elf(String name) {
        this.name = name;
    }

    @Override
    public void onCreate(Toy toy) {
        System.out.println(toy.getDescription() + " est construit");
    }

    @Override
    public void onDecoration(Toy toy) {
        System.out.println(toy.getDescription() + " a reçu une amélioration");
    }
}
