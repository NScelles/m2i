package org.example.tpproduct.Ihm;

import org.example.tpproduct.models.Customer;

import static org.example.utils.Utils.getInt;
import static org.example.utils.Utils.getString;

public class CustomerIhm extends Ihm {
    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("""
                        1 - Ajouter un client
                        2 - Voir tous les clients
                        3 - Rechercher un client
                        4 - Modifier un client
                        5 - Supprimer un client
                        0 - Quitter
                        """);
            int choice = getInt("Choix :");
            switch (choice) {
                case 0 -> running=false;
                case 1 -> createCustomer();
                case 2 -> showAllCustomer();
                case 3 -> showCustomerById();
                case 4 -> updateCustomer();
                case 5 -> deleteCustomer();
                default -> System.out.println("Choix invalide");
            }
        }
        System.out.println("Au revoir !");
    }


    private static void deleteCustomer() {
        int id = getInt("Quels est l'ID du client ?");
        storeService.deleteCustomer(storeService.getCustomer(id));
    }

    private static void updateCustomer() {
        int id = getInt("Quels est l'ID du client ?");
        Customer customer = storeService.getCustomer(id);
        String name = getString("Votre nom prénom: ");
        customer.setName(name);
        storeService.updateCutomer(customer);
    }

    private static void showCustomerById() {
        int id = getInt("Quels est l'ID du client ?");
        System.out.println(storeService.getCustomer(id));
    }

    private static void showAllCustomer() {
        for(Customer customer: storeService.getCustomers())
            System.out.println(customer);
    }

    private static void createCustomer() {
        String name = getString("Votre nom prénom : ");
        storeService.createCustomer(name);
    }
}
