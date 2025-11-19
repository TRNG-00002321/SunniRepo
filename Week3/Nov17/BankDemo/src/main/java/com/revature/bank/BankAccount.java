package com.revature.bank;

import com.revature.ex.LowBalanceException;
import com.revature.ex.NegativeTransactionException;

//If balance < 5000 throw exception.
//Handle input exceptions for negative values.
public abstract class BankAccount {
    String accountId;
    String accountName;
    private double balance;

    public BankAccount(String id, String name, double balance){
        this.accountId = id;
        this.accountName = name;
        this.balance = balance;
    }

    public BankAccount(String id, String name){
        this.accountId = id;
        this.accountName = name;
        this.balance = 0.0;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double deposit(double amount) throws NegativeTransactionException {
        if(amount < 0)
            throw new NegativeTransactionException("Negative Deposit Amount");
        return balance+=amount;
    }

    public abstract double withdraw(double amount) throws NegativeTransactionException, LowBalanceException;

    @Override
    public String toString() {
        return getClass().getSimpleName() +  "{ " +
                "accountId: " + accountId + ", " +
                "accountName: " + accountName + ", " +
                "balance: " + balance + "}";
    }
}
