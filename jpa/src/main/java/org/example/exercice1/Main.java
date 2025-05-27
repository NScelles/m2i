package org.example.exercice1;

import org.example.exercice1.entity.animal.AnimalDiet;
import org.example.exercice1.services.ZooService;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ZooService zooService = new ZooService();
//        zooService.createAnimal("toto",5, AnimalDiet.CARNIVORE, Date.valueOf("2002-05-12"));
//        zooService.createAnimal("Salimou",6, AnimalDiet.HERBIVORE, Date.valueOf("2025-05-20"));
//        zooService.createAnimal("Nelou",5, AnimalDiet.HERBIVORE, Date.valueOf("2002-05-12"));
//        zooService.createAnimal("toto",5, AnimalDiet.OMNIVORE, Date.valueOf("2002-05-12"));
        System.out.println(zooService.getAnimalById(1));
        System.out.println(zooService.getByName("toto"));
        System.out.println(zooService.getByDiet(AnimalDiet.HERBIVORE));
    }
}
