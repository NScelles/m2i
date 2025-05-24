package org.example.tpbank.dao;

import org.example.tpbank.models.Account;
import org.example.tpbank.models.Customer;
import org.example.utils.BaseDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDao extends BaseDao<Account> {


    private OperationDao operationDao = new OperationDao(this.connection);
    private static final String NAMETABLE = "accounts";

    public AccountDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Account element) throws SQLException {
        request = "INSERT INTO "+NAMETABLE+" (id_customer) VALUES (?)";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1,element.getCustomerId());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRow == 1;
    }

    @Override
    public boolean update(Account element) throws SQLException {
        request = "UPDATE "+ NAMETABLE +" SET id_customer = ? WHERE id_account = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,element.getCustomerId());
        statement.setInt(2,element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public boolean delete(Account element) throws SQLException {
        request = "DELETE FROM "+ NAMETABLE +" WHERE id_account = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public Account get(int id) throws SQLException {
        Account account = null;
        request = "SELECT a.id_account, a.id_customer, c.first_name, c.last_name, c.phone_nbr, SUM(amount) AS total_amount FROM "+ NAMETABLE +" AS a INNER JOIN customers AS c ON a.id_customer=c.id_customer INNER JOIN operations AS o ON o.id_account=a.id_account GROUP BY a.id_account HAVING a.id_account = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,id);
        resultSet = statement.executeQuery();
        if (resultSet.next()){
            account = new Account(
                    resultSet.getInt("a.id_account"),
                    resultSet.getInt("a.id_customer"),
                    new Customer(
                            resultSet.getString("c.first_name"),
                            resultSet.getString("c.last_name"),
                            resultSet.getString("c.phone_nbr")
                    ),
                    operationDao.getOperations(resultSet.getInt("a.id_account")),
                    resultSet.getDouble("total_amount")
            );
        }
        return account;
    }

    @Override
    public List<Account> get() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        request = "SELECT a.id_account, a.id_customer, c.first_name, c.last_name, c.phone_nbr, SUM(amount) AS total_amount" +
                "FROM "+ NAMETABLE +" AS a " +
                "INNER JOIN customers AS c ON a.id_customer=c.id_customer " +
                "INNER JOIN operations AS o ON o.id_account=a.id_account " +
                "GROUP BY a.id_account ";
        statement = connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            accounts.add(
                    new Account(
                            resultSet.getInt("a.id_account"),
                            resultSet.getInt("a.id_customer"),
                            new Customer(
                                    resultSet.getString("first_name"),
                                    resultSet.getString("last_name"),
                                    resultSet.getString("phone_nbr")
                            ),
                            operationDao.getOperations(resultSet.getInt("a.id_account")),
                            resultSet.getDouble("total_amount")
                )
            );
        }
        return accounts;
    }




}
