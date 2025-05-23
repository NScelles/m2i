package org.example.exercice2.services;

import org.example.exercice2.dao.AccountDao;
import org.example.exercice2.dao.CustomerDao;
import org.example.exercice2.dao.OperationDao;
import org.example.exercice2.models.Account;
import org.example.exercice2.models.Customer;
import org.example.exercice2.models.Operation;

import java.sql.Connection;
import java.sql.SQLException;

import static org.example.utils.ConnectionUtils.getConnection;
import static org.example.utils.ConnectionUtils.makeConnection;

public class BankService {
    private AccountDao accountDao;
    private CustomerDao customerDao;
    private OperationDao operationDao;
    private Connection connection;

    public BankService() {
        try {
            connection = getConnection("tp_jdbc");
            accountDao = new AccountDao(connection);
            customerDao = new CustomerDao(connection);
            operationDao = new OperationDao(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createCustomerAccount(String firstName, String lastName, String phone){
        Customer customer = new Customer(firstName,lastName,phone);
        Account account;
        try {
            if(customerDao.save(customer)){
                int customerId = customerDao.get().getLast().getId();
                account = new Account(customerId,customer);
                if(accountDao.save(account))
                    return true;
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean createOperation(int idAccount, double amount){
        Operation operation = new Operation(amount,operationDao.getOperationStatus(amount),idAccount);
        try {
            if(operationDao.save(operation)){
                    return true;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Account getAccount(int idAcount){
        try {
            return accountDao.get(idAcount);
        }catch (SQLException e){
            throw new RuntimeException(e);

        }
    }


}
