package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.example.utils.Utils.*;

public class ConnectionUtils {
    public static Connection getSQLConnection(String db) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/"+db;
        String username = "root";
        String password = getPassword();

            Connection connection = DriverManager.getConnection(url,username,password);
            return connection;
    }

    public static Connection getConnection(String db) throws SQLException {
        Connection connection = null;
            connection = org.example.utils.ConnectionUtils.getSQLConnection(db);
            if (connection != null){
                System.out.println("\n\n\n\n\n\n\n\nConnected !!!");
            }else {
                System.out.println("Connexion failed verify ConnectionUtils");
            }
        return connection;
    }


    public static Connection makeConnection(){
        Connection connection = null;
        try {
             connection = org.example.utils.ConnectionUtils.getSQLConnection("demo_jdbc");
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
