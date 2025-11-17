package com.revature.bank;

import com.revature.ex.LowBalanceException;
import com.revature.ex.NegativeTransactionException;

public class SavingAccount extends BankAccount implements SimpleInterest{

    public SavingAccount(String id, String name, double balance){
        super(id, name, balance);
    }

    @Override
    public double withdraw(double amount) throws NegativeTransactionException, LowBalanceException {
        if (amount < 0)
            throw new NegativeTransactionException("Negative Withdrawal Amount: " + amount);

        if(super.getBalance() < amount)
            throw new LowBalanceException("Insufficient Funds: " + super.getBalance()
                    + " for withdrawal amount: " + amount);

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
