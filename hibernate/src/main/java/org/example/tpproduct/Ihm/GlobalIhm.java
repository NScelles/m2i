package org.example.tpproduct.Ihm;

import static org.example.utils.Utils.getInt;

public class GlobalIhm extends Ihm {
    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("""
                        1 - Gerer les produits
                        2 - Gerer les ventes
                        3 - Gerer les clients
                        0 - Quitter
                        """);

            int choice = getInt("Choix :");
            switch (choice) {
                case 0 -> running=false;
                case 1 -> ArticleIhm.start();
                case 2 -> SellingIhm.start();
                case 3 -> CustomerIhm.start();
                default -> System.out.println("Choix invalide");
            }
        }
        System.out.println("Au revoir !");
    }
}
