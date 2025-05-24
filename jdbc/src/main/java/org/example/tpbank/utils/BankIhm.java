package org.example.tpbank.utils;

import org.example.tpbank.models.Account;
import org.example.tpbank.services.BankService;

import static org.example.utils.Utils.*;

public class BankIhm {
    private static BankService bankService = new BankService();

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("""
                        1 - Créer un client et un compte
                        2 - Faire un dépot
                        3 - Faire un retrait
                        4 - Afficher un compte
                        0 - Quitter
                        """);
            int choice = getInt("Choix :");
            switch (choice) {
                case 0 -> running=false;
                case 1 -> createCustomerAccount();
                case 2 -> makeDeposit();
                case 3 -> makeWithdrawl();
                case 4 -> showAccount();
                default -> System.out.println("Choix invalide");
            }
        }
        System.out.println("Au revoir !");
    }

    private static void showAccount() {
        Account account = bankService.getAccount(getInt("ID du compte à afficher :"));
        System.out.println(account);
    }

    private static void makeWithdrawl() {
        int idAccount = getInt("Quels est l'ID du compte ?");
        double amount = getDouble("Quel est le montant à retirer ?");
        bankService.createOperation(idAccount,-amount);
    }

    private static void makeDeposit() {
        int idAccount = getInt("Quels est l'ID du compte ?");
        double amount = getDouble("Quel est le montant à déposer ?");
        bankService.createOperation(idAccount,amount);
    }

    private static void createCustomerAccount() {
        String firstname = getString("Quel est son prénom ?");
        String lastname = getString("Quel est son nom ?");
        String phone = getString("Quel est sont numéro de téléphone ?");
        bankService.createCustomerAccount(firstname,lastname,phone);
    }


}
