package org.example.tpcomputer.Ihm;

import org.example.tpcomputer.models.Computer;
import org.example.tpcomputer.models.Identification;
import org.example.tpcomputer.models.Project;
import org.example.tpcomputer.services.EquipementService;

import static org.example.utils.Utils.getInt;
import static org.example.utils.Utils.getString;

public class EquipementIhm extends Ihm {



    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("""
                        1 - Ajouter un pc
                        2 - Voir tous les PCs
                        3 - Rechercher un PC
                        4 - Modifier un PC
                        5 - Supprimer un PC
                        6 - Voir les Processeurs
                        7 - Voir les OS
                        8 - Voir les projets associé à un PC
                        0 - Quitter la gestion d'équipement
                        """);
            int choice = getInt("Choix :");
            switch (choice) {
                case 0 -> running=false;
                case 1 -> createPc();
                case 2 -> showAllPc();
                case 3 -> showPcById();
                case 4 -> updatePc();
                case 5 -> deletePc();
                case 6 -> showProcessors();
                case 7 -> showAllOS();
                case 8 -> showProjectPc();
                default -> System.out.println("Choix invalide");
            }
        }
        System.out.println("Au revoir !");
    }

    private static void showProjectPc() {
        int id = getInt("Quels est l'ID du PC ?");

        String projectsString = "Les projets du PC numéro: ";
        for (Project project : equipementService.getComputer(id).getProjects())
            projectsString += "\n" + project.getId() + " | " + project.getName() + " | " + project.getDescription() ;
        System.out.println(projectsString);
    }

    private static void showAllOS() {
        System.out.println(equipementService.getAllOS());
    }

    private static void showProcessors() {
        System.out.println(equipementService.getProcessors());
    }


    private static void deletePc() {
        int id = getInt("Quels est l'ID du PC ?");
        equipementService.deleteComputer(id);
    }

    private static void updatePc() {
        int id = getInt("Quels est l'ID du PC ?");
        String model = getString("Quels est le model du PC ?");
        String ipAddress = getString("Quels est le adresse IP  du PC ?");
        String macAddress = getString("Quels est le adresse mac  du PC ?");
        Identification identification = Identification.builder().ipAdress(ipAddress).macAdress(macAddress).build();
        equipementService.updateComputer(Computer.builder().id(id).model(model).identification(identification).build());
    }

    private static void showAllPc() {
        System.out.println(equipementService.getComputers());
    }


    private static void showPcById() {
        int id = getInt("Quels est l'ID du PC ?");
        System.out.println(equipementService.getComputer(id));
    }

    private static void createPc() {
        String model = getString("Quels est le model du PC ?");
        String ipAddress = getString("Quels est le adresse IP  du PC ?");
        String macAddress = getString("Quels est le adresse mac  du PC ?");
        int idProcessor = getInt("Quels est l'ID du processeur ?");
        int idOS = getInt("Quels est l'ID de l'OS ?");
        Identification identification = Identification.builder().ipAdress(ipAddress).macAdress(macAddress).build();
        equipementService.createComputer(model, identification,idProcessor,idOS);
    }
}
