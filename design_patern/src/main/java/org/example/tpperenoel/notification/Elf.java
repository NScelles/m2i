package org.example.tpperenoel.notification;

import org.example.tpperenoel.factory.Toy;

public class Elf implements Observer {

    private String name;

    public Elf(String name) {
        this.name = name;
    }

    @Override
    public void onCreate(Toy toy) {
        System.out.println(name + " a reçu la notification :" + toy.getDescription() + " est construit");
    }
}
