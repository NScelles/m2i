package org.example.exercices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.utils.ConnectionUtils.closeConnection;
import static org.example.utils.ConnectionUtils.makeConnection;
import static org.example.utils.Utils.getInt;
import static org.example.utils.Utils.getString;

public class Exercice1 {
    public static void main(String[] args) {
        Connection connection = makeConnection();
        int userResponse;
        try {
            System.out.println("Bienvenue dans le lycée Marie Curie:");
            do {
                System.out.println("""
                        1 - Ajouter un étudiant
                        2 - Afficher tous les étudiants
                        3 - Afiicher un étudiant par son ID
                        4 - Supprimer un étudiant
                        0 - Quitter
                        """);
                userResponse = getInt("Choix :");
                switch (userResponse) {
                    case 0 -> System.out.println("Aurevoir");
                    case 1 -> addStudent(connection);
                    case 2 -> showStudents(connection);
                    case 3 -> showStudent(connection);
                    case 4 -> deleteStudent(connection);
                }
            } while (userResponse != 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
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
        if (studend.getId() == 0)
            System.out.println(studend);
        else
            System.out.println("C'est étudiant n'existe pas !");
    }

    private static void showStudents(Connection connection) throws SQLException {
        for (Student student : StudentService.getStudents(connection))
            System.out.println(student);
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
