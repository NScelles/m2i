package org.example.creational;

import org.example.creational.builder.Maison;
import org.example.creational.builder.Person;

public class Main {
    public static void main(String[] args) {
        Maison maison= new Maison.Builder().nbEtage(10).piscine(true).typeToiture("myconnaispas").couleur("bleu").build();
    }
}
