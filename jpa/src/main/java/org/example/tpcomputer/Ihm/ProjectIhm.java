package org.example.tpcomputer.Ihm;

import org.example.tpcomputer.models.Project;

import static org.example.utils.Utils.getInt;
import static org.example.utils.Utils.getString;

public class ProjectIhm extends Ihm {

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("""
                        1 - Ajouter un projet
                        2 - Voir tous les projets
                        3 - Rechercher un projet
                        4 - Modifier un projet
                        5 - Supprimer un projet
                        6 - Ajouter un PC à un projet
                        0 - Quitter la gestion de projets
                        """);
            int choice = getInt("Choix :");
            switch (choice) {
                case 0 -> running=false;
                case 1 -> createProjet();
                case 2 -> showAllProjet();
                case 3 -> showProjetById();
                case 4 -> updateProjet();
                case 5 -> deleteProject();
                case 6 -> addComputerProject();
                default -> System.out.println("Choix invalide");
            }
        }
        System.out.println("Au revoir !");
    }

    private static void addComputerProject() {
        int idProject = getInt("Quels est l'ID du Projet ?");
        int idComputer = getInt("Quels est l'ID du PC ?");
        equipementService.addComputerProject(idProject, idComputer);
    }


    private static void deleteProject() {
        int id = getInt("Quels est l'ID du Projet ?");
        equipementService.deleteProject(id);
    }

    private static void updateProjet() {
        int id = getInt("Quels est l'ID du Projet ?");
        String name = getString("Quels est le nom du Projet ?");
        String description = getString("Quels est la description du Projet ?");
        equipementService.updateProject(Project.builder().id(id).name(name).description(description).build());
    }

    private static void showAllProjet() {
        System.out.println(equipementService.getProjects());
    }


    private static void showProjetById() {
        int id = getInt("Quels est l'ID du PC ?");
        System.out.println(equipementService.getComputer(id));
    }

    private static void createProjet() {
        String name = getString("Quels est le nom du Projet ?");
        String description = getString("Quels est la description du Projet ?");
        equipementService.createProject(name, description);
    }
}
