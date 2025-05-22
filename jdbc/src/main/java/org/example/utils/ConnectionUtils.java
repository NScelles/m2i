package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.example.utils.Utils.getString;

public class ConnectionUtils {
    public static Connection getSQLConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/demo_jdbc";
        String username = "root";
        String password = getString("Mot de passe BDD : ");

            Connection connection = DriverManager.getConnection(url,username,password);
            return connection;
    }

    public static Connection makeConnection(){
        Connection connection = null;
        try {
             connection = org.example.utils.ConnectionUtils.getSQLConnection();
            if (connection != null){
                System.out.println("\n\n\n\n\n\n\n\nConnected !!!");
            }else {
                System.out.println("Connexion failed verify ConnectionUtils");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
