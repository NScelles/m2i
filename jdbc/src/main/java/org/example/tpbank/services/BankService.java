package org.example.tpbank.services;

import org.example.tpbank.dao.AccountDao;
import org.example.tpbank.dao.CustomerDao;
import org.example.tpbank.dao.OperationDao;
import org.example.tpbank.models.Account;
import org.example.tpbank.models.Customer;
import org.example.tpbank.models.Operation;
import org.example.tpbank.models.OperationStatus;

import java.sql.Connection;
import java.sql.SQLException;

import static org.example.utils.ConnectionUtils.getConnection;

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
        Operation operation;
        try {
            if(customerDao.save(customer)){
                int customerId = customerDao.get().getLast().getId();
                account = new Account(customerId,customer);
                if(accountDao.save(account)) {
                    operation = new Operation(0.0, OperationStatus.DEPOSIT,customerId);
                    if (operationDao.save(operation))
                        return true;
                }
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
