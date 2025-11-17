package com.revature.bank;

public class CheckingAccount extends BankAccount{

    public CheckingAccount(String id, String name, double balance) {

        super(id, name, balance);
    }

//    @Override
//    public double withdraw(double amount){ // Deducts surcharge from withdrawn amount
//        double newBalance = super.getBalance() - amount;
//        super.setBalance(newBalance);
//        return amount*(1-surcharge);
//    }

    @Override
    public double withdraw(double amount){ // Deducts surcharge from account balance
        double surcharge = 0.01 / 100;
        double newBalance = super.getBalance() - amount*(1+ surcharge);
        super.setBalance(newBalance);
        return amount;
    }
}
