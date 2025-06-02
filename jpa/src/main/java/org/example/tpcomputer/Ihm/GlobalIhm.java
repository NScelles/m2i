package org.example.tpcomputer.Ihm;

import static org.example.utils.Utils.getInt;

public class GlobalIhm extends Ihm {

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("""
                        1 - Gérer les projets
                        2 - Gérer les équipements
                        0 - Quitter
                        """);
            int choice = getInt("Choix :");
            switch (choice) {
                case 0 -> running=false;
                case 1 -> ProjectIhm.start();
                case 2 -> EquipementIhm.start();
                default -> System.out.println("Choix invalide");
            }
        }
        System.out.println("Au revoir !");
    }
}
