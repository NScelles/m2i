package org.example.demos;

import org.example.utils.ConnectionUtils;

import java.sql.*;

import static org.example.utils.Utils.getString;

public class Demo2{
    public static void main(String[] args) {
        Connection connection = null;
        try {
            /// Make connection to DB
            connection = ConnectionUtils.getSQLConnection("demo_jdbc");

            if (connection != null){
                System.out.println("Connected !!!");
            }else {
                System.out.println("Connection failed verify ConnectionUtils.class");
            }
            /// Start a request
            String lastname = getString("Saisir un nom :");
            String firstname = getString("Saisir un prénom :");
            ///
            //String request = "INSERT INTO users (first_name,last_name) VALUES ('"+firstname+"','"+lastname+"')";

            /// Execute the request

            /// Fisrt way : Execute a request without back
            //Statement statement = connection.createStatement();
            //statement.execute(request);
            //System.out.println("Request executed");

              /// Second Way : With a prepared request
//            String preparedRequest = " INSERT INTO users (first_name,last_name) VALUES (?,?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(preparedRequest);
//            preparedStatement.setString(1,firstname);
//            preparedStatement.setString(2,lastname);
//             preparedStatement.execute(); // Return booleen
//            int nbRow = preparedStatement.executeUpdate();
//            System.out.println( nbRow + " row(s) affected");

            // get id if the request works
            String preparedRequest = " INSERT INTO users (first_name,last_name) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(preparedRequest,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,firstname);
            preparedStatement.setString(2,lastname);
            int nbRows = preparedStatement.executeUpdate();
            System.out.println( nbRows + " row(s) affected");

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            System.out.println("Nombre de ligne : "+nbRows);
            if(resultSet.next()){
                System.out.println("Id de la ligne inserer : "+resultSet.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
