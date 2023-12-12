package org.levelingup.models;

import org.bson.types.ObjectId;

public class Account {
    private ObjectId id;
    private String accountNumber;
    private String pin;
    private String balance;
    public Account() {}
    public Account(String accountNumber, String pin, String balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public ObjectId getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBalance() {
        return balance;
    }

    public String getPin() {
        return pin;
    }
}

