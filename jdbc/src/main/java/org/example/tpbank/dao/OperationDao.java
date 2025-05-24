package org.example.tpbank.dao;

import org.example.tpbank.models.Operation;
import org.example.tpbank.models.OperationStatus;
import org.example.utils.BaseDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.example.tpbank.models.OperationStatus.DEPOSIT;

public class OperationDao extends BaseDao<Operation> {

    private static final String NAMETABLE = "operations";


    public OperationDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Operation element) throws SQLException {
        request = "INSERT INTO "+ NAMETABLE + " (amount,operation_status,id_account) VALUES (?,?,?)";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1,element.getAmount());
        statement.setString(2,getOperationStatus(element.getAmount()).name());
        statement.setInt(3,element.getAccountId());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRow == 1;
    }

    @Override
    public boolean update(Operation element) throws SQLException {
        request = "UPDATE "+ NAMETABLE +" SET amount = ?, operation_status = ?, id_account = ? WHERE id_operation = ?";
        statement = connection.prepareStatement(request);
        statement.setDouble(1,element.getAmount());
        statement.setString(2,getOperationStatus(element.getAmount()).name());
        statement.setInt(3,element.getAccountId());
        statement.setInt(4,element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public boolean delete(Operation element) throws SQLException {
        request = "DELETE FROM "+ NAMETABLE +" WHERE id_operation = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public Operation get(int id) throws SQLException {
        Operation operation = null;
        request = "SELECT * FROM "+ NAMETABLE +" WHERE id_operation = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,id);
        resultSet = statement.executeQuery();
        if (resultSet.next()){
            operation = new Operation(
                    resultSet.getInt("id_operation"),
                    resultSet.getDouble("amount"),
                     getOperationStatus(resultSet.getString("last_name")),
                    resultSet.getInt("phone_nbr")
            );
        }
        return operation;
    }

    @Override
    public List<Operation> get() throws SQLException {
        List<Operation> operations = new ArrayList<>();
        request = "SELECT * FROM " + NAMETABLE;
        statement = connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            Operation operation = new Operation(
                    resultSet.getInt("id_operation"),
                    resultSet.getDouble("amount"),
                    getOperationStatus(resultSet.getString("last_name")),
                    resultSet.getInt("phone_nbr")
            );
            operations.add(operation);
        }
        return operations;
    }

    public OperationStatus getOperationStatus(String status){
        if(status.equals(DEPOSIT.name()))
            return DEPOSIT;
        else
            return OperationStatus.WITHDRAWL;
    }

    public OperationStatus getOperationStatus(double amount){
        if(amount>=0)
            return DEPOSIT;
        else
            return OperationStatus.WITHDRAWL;
    }

    public List<Operation> getOperations(int idAmount) throws SQLException {
        List<Operation> operations = new ArrayList<>();
        request = "SELECT * FROM "+ NAMETABLE +" WHERE id_account = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,idAmount);
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            Operation operation = new Operation(
                    resultSet.getInt("id_operation"),
                    resultSet.getDouble("amount"),
                    getOperationStatus(resultSet.getString("operation_status")),
                    resultSet.getInt("id_account")
            );
            operations.add(operation);
        }
        return operations;
    }
}
