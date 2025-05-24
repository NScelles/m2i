package org.example.tpbank.models;

import lombok.Data;

public @Data class Operation {
    private int id;
    private double amount;
    private OperationStatus status;
    private int accountId;

    public Operation() { }

    public Operation(double amount, OperationStatus status, int accountId) {
        this.amount = amount;
        this.status = status;
        this.accountId = accountId;
    }

    public Operation(int id, double amount, OperationStatus status, int accountId) {
        this.id = id;
        this.amount = amount;
        this.status = status;
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "\n" +
                "amount: " + amount +
                " status: " + status;
    }
}
