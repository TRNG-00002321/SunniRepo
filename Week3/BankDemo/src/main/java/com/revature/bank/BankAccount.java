package com.revature.bank;

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

    public double deposit(double amount){
        return balance+=amount;
    }

    public abstract double withdraw(double amount);

    @Override
    public String toString() {
        return getClass().getSimpleName() +  "{ " +
                "accountId: " + accountId + ", " +
                "accountName: " + accountName + ", " +
                "balance: " + balance + "}";
    }
}
