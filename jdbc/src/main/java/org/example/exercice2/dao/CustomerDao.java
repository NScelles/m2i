package org.example.exercice2.dao;

import org.example.exercice2.models.Customer;
import org.example.utils.BaseDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDao extends BaseDao<Customer> {

    private static final String NAMETABLE = "customers";
    public CustomerDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Customer element) throws SQLException {
        request = "INSERT INTO "+ NAMETABLE + " (first_name,last_name,phone_nbr) VALUES (?,?,?)";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,element.getFirstName());
        statement.setString(2,element.getLastName());
        statement.setString(3,element.getPhone());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRow == 1;
    }

    @Override
    public boolean update(Customer element) throws SQLException {
        request = "UPDATE "+ NAMETABLE +" SET first_name = ?, last_name = ?, phone_nbr = ? WHERE id_customer = ?";
        statement = connection.prepareStatement(request);
        statement.setString(1,element.getFirstName());
        statement.setString(2,element.getLastName());
        statement.setString(3,element.getPhone());
        statement.setInt(4,element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public boolean delete(Customer element) throws SQLException {
        request = "DELETE FROM "+ NAMETABLE +" WHERE id_customer = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public Customer get(int id) throws SQLException {
        Customer customer = null;
        request = "SELECT * FROM "+ NAMETABLE +" WHERE id_customer = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,id);
        resultSet = statement.executeQuery();
        if (resultSet.next()){
            customer = new Customer(
                    resultSet.getInt("id_customer"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("phone_nbr")
            );
        }
        return customer;
    }

    @Override
    public List<Customer> get() throws SQLException {
        List<Customer> persons = new ArrayList<>();
        request = "SELECT * FROM " + NAMETABLE;
        statement = connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            Customer person = new Customer(resultSet.getInt("id_customer"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("phone_nbr")
            );
            persons.add(person);
        }
        return persons;
    }

}
