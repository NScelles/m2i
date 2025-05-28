package org.example.exercice1.ihm;

import org.example.exercice1.entity.animal.Animal;
import org.example.exercice1.entity.animal.AnimalDiet;
import org.example.exercice1.services.ZooService;

import java.sql.Date;

import static org.example.utils.Utils.getInt;
import static org.example.utils.Utils.getString;

public class ZooIhm {

    private static ZooService zooService = new ZooService();

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("""
                        1 - Créer un animal
                        2 - Voir un animal
                        3 - Rechercher des animauw par leur nom
                        4 - Afficher les animaux selon leur régime alimentaire
                        0 - Quitter
                        """);
            int choice = getInt("Choix :");
            switch (choice) {
                case 0 -> running=false;
                case 1 -> createAnimal();
                case 2 -> showAnimalById();
                case 3 -> showAnimalsByName();
                case 4 -> showAnimalByDiet();
                default -> System.out.println("Choix invalide");
            }
        }
        System.out.println("Au revoir !");
    }

    private static void showAnimalByDiet() {
        String diet = getString("Quels est son regime alimentaire (carnivore,herbivore,omnivore) ?");
        for (Animal animal:zooService.getByDiet(AnimalDiet.getAnimalDiet(diet)))
            System.out.println(animal);
    }

    private static void showAnimalsByName() {
        String name = getString("Quels est le nom des animaux : ?");
        for (Animal animal:zooService.getByName(name))
            System.out.println(animal);
    }

    private static void showAnimalById() {
        int idAnimal = getInt("Quels est l'ID de l'animal ?");
        System.out.println(zooService.getAnimalById(idAnimal));
    }

    private static void createAnimal() {
        String name = getString("Quel est son nom ?");
        int age = getInt("Quel est son age ?");
        String diet = getString("Quel est son régime alimentaire (carnivore,herbivore,omnivore) ?");
        String arrivalDate = getString("Quand est-il arrivé ? (yyyy-MM-dd) ?)");
        zooService.createAnimal(name,age, AnimalDiet.getAnimalDiet(diet), Date.valueOf(arrivalDate));
    }
}

