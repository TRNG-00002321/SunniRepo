package com.revature.bank;

public class SavingAccount extends BankAccount implements SimpleInterest{

    public SavingAccount(String id, String name, double balance){
        super(id, name, balance);
    }

    @Override
    public double withdraw(double amount){
        double newBalance = super.getBalance() - amount;
        super.setBalance(newBalance);
        return amount;
    }

    @Override
    public double calculateInterest(double percentage){
        double newBalance = super.getBalance()*(1 + percentage/100);
        super.setBalance(newBalance);
        return newBalance;
    }

    public double applyInterest(){
        return calculateInterest(5);
    }
}
