package org.example.demos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.example.utils.ConnectionUtils.closeConnection;
import static org.example.utils.ConnectionUtils.makeConnection;

public class Demo3 {
    public static void main(String[] args) {
        Connection connection = makeConnection();
        String request = "SELECT * FROM users";
        try {
            /// Basic request SELECT
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+") "+resultSet.getString(2)+" "+resultSet.getString(3));
            }
            /// Request SELECT by id
            String requestById = "SELECT * FROM users WHERE id_user = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(requestById);
            preparedStatement.setInt(1,3);
            ResultSet resultSet2 = preparedStatement.executeQuery();
            if(resultSet2.next())
                System.out.println(resultSet2.getInt(1) + ") " + resultSet2.getString(2) + " " + resultSet2.getString(3));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }
}
