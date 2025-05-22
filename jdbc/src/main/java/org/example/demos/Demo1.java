package org.example.demos;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.example.utils.Utils.getString;

public class Demo1 {
    public static void main(String[] args) {
        intro();
        /// 1) New Project
        /// 2) Add Dependencies
        /// 3) Add the connector corresponding to my DB (MySQL,Postgre,...)
        /// 4) Prepare DB connection info

        String url = "jdbc:mysql://localhost:3306/demo_jdbc";
        String username = "root";
        String password = getString("Mot de passe BDD : ");

        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            if (connection != null){
                System.out.println("La connexion est OK !!!");
            }else {
                System.out.println("Connexion echoué");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        /// To upgrade it put this code in a class show ConnectionUtils and demo 2
    }

    public static void intro(){
        String name = "JDBC";
        try {
            name = FigletFont.convertOneLine(name);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println(name);

    }
}