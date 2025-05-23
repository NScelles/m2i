package org.example.exercice1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService{

    public static int deleteStudent(Connection connection,int id) throws SQLException {
        String request = "DELETE FROM student WHERE id_student = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(request);
        preparedStatement.setInt(1,id);
        int nbRow = preparedStatement.executeUpdate();
        System.out.println( nbRow + " row(s) affected");
        return nbRow;
    }

    public static Student getStudent(Connection connection, int id) throws SQLException {
        String request = "SELECT * FROM student WHERE id_student = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(request);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
           return new Student(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5));
        return new Student();
    }

    public static List<Student> getStudents(Connection connection) throws SQLException {
        List<Student> students = new ArrayList<>();
        String request = "SELECT * FROM student";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(request);
        while (resultSet.next())
           students.add(new Student(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5)));
        return students;
    }

    public static int addStudent(Connection connection,String firstname, String lastname, int idClass, String degreeDate) throws SQLException {
        String preparedRequest = "INSERT INTO student (first_name,last_name,id_class,degree_date) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(preparedRequest);
        preparedStatement.setString(1,firstname);
        preparedStatement.setString(2,lastname);
        preparedStatement.setInt(3,idClass);
        preparedStatement.setString(4,degreeDate);
        int nbRow = preparedStatement.executeUpdate();
        return nbRow;
    }
}
