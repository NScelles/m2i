package org.example.creational;

import org.example.creational.builder.House;

public class Main {
    public static void main(String[] args) {
        House maison = new House.Builder()
                .floor(10)
                .pool(true)
                .roofType("Tuile")
                .color("bleu")
                .build();

        House house = new House.Builder()
                .roofType("Chaume")
                .pool(false)
                .floor(1)
                .color("rose")
                .build();
    }
}
