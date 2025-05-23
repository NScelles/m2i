package org.example.utils;



import org.example.exercice1.Student;
import org.example.exercice1.StudentService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static org.example.utils.Utils.getInt;
import static org.example.utils.Utils.getString;

public class ConsoleIhm<T> {
    private T personService;

    public static void start(Connection connection) throws SQLException {
        boolean running = true;
        while (running) {
            System.out.println("""
                        1 - Ajouter un étudiant
                        2 - Afficher tous les étudiants
                        3 - Afiicher un étudiant par son ID
                        4 - Supprimer un étudiant
                        0 - Quitter
                        """);
            int choice = getInt("Choix :");
            switch (choice) {
                case 0 -> running=false;
                case 1 -> addStudent(connection);
                case 2 -> showStudents(connection);
                case 3 -> showStudent(connection);
                case 4 -> deleteStudent(connection);
                default -> System.out.println("Choix invalide");
            }
        }
        System.out.println("Au revoir !");
    }

    private static void deleteStudent(Connection connection) throws SQLException {
        int idStudent = getInt("Quel est l'id de l'éudiant ?");
        String request = "DELETE FROM student WHERE id_student = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(request);
        preparedStatement.setInt(1, idStudent);
        int nbRow = preparedStatement.executeUpdate();
        System.out.println(nbRow + " row(s) affected");
    }

    private static void showStudent(Connection connection) throws SQLException {
        int idStudent = getInt("Quel est l'id de l'éudiant ?");
        Student studend = StudentService.getStudent(connection, idStudent);
        if (studend.getId() != 0)
            System.out.println(studend);
        else
            System.out.println("C'est étudiant n'existe pas !");
    }


    private static void showStudents(Connection connection) throws SQLException {
        List<Student> students = StudentService.getStudents(connection);
        if (!students.isEmpty())
            for (Student student : students)
                System.out.println(student);
        else
            System.out.println("Il n'y a pas d'étudiant");
    }

    public static void addStudent(Connection connection) throws SQLException {
        String firstname = getString("Saisir un prénom :");
        String lastname = getString("Saisir un nom :");
        int idClass = getInt("Saisir son numéro de classe :");
        String degreeDate = getString("Saisir la date d'obtention du diplome");
        int nbRow = StudentService.addStudent(connection,firstname,lastname,idClass,degreeDate);
        System.out.println( nbRow + " row(s) affected");
    }

}
