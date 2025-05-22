package org.example.exercices;

import java.sql.*;

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
            do{
                System.out.println("""
                        1 - Ajouter un étudiant
                        2 - Afficher tous les étudiants
                        3 - Afiicher un étudiant par son ID
                        4 - Supprimer un étudiant
                        0 - Quitter
                        """);
                userResponse = getInt("Choix :");
                switch (userResponse){
                    case 0 -> System.out.println("Aurevoir");
                    case 1 -> addStudent(connection);
                    case 2 -> showStudents(connection);
                    case 3 -> showStudent(connection);
                    case 4 -> deleteStudent(connection);
                }


            }while (userResponse != 0);
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
        preparedStatement.setInt(1,idStudent);
        int nbRow = preparedStatement.executeUpdate();
        System.out.println( nbRow + " row(s) affected");
    }

    private static void showStudent(Connection connection) throws SQLException {
        int idStudent = getInt("Quel est l'id de l'éudiant ?");
        String request = "SELECT * FROM student WHERE id_student = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(request);
        preparedStatement.setInt(1,idStudent);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
            System.out.println(resultSet.getInt(1)+") "+resultSet.getString(2)+" "+resultSet.getString(3) + " classe " + resultSet.getInt(4) + " a obtenu le diplome le " + resultSet.getString(5));
    }

    private static void showStudents(Connection connection) throws SQLException {
        String request = "SELECT * FROM student";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(request);
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+") "+resultSet.getString(2)+" "+resultSet.getString(3) + " classe " + resultSet.getInt(4) + " a obtenu le diplome le " + resultSet.getString(5));
        }
    }


    public static void addStudent(Connection connection) throws SQLException {
        String firstname = getString("Saisir un prénom :");
        String lastname = getString("Saisir un nom :");
        int id_class = getInt("Saisir son numéro de classe :");
        String degreeDate = getString("Saisir la date d'obtention du diplome");

        String preparedRequest = " INSERT INTO student (first_name,last_name,id_class,degree_date) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(preparedRequest);
        preparedStatement.setString(1,firstname);
        preparedStatement.setString(2,lastname);
        preparedStatement.setInt(3,id_class);
        preparedStatement.setString(4,degreeDate);

        int nbRow = preparedStatement.executeUpdate();
        System.out.println( nbRow + " row(s) affected");
    }
}
