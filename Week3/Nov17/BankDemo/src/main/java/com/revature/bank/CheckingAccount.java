package com.revature.bank;

import com.revature.ex.LowBalanceException;
import com.revature.ex.NegativeTransactionException;

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
    public double withdraw(double amount) throws NegativeTransactionException, LowBalanceException {// Deducts surcharge from account balance
        if(amount < 0)
            throw new NegativeTransactionException("Negative Withdrawal Amount: " + amount);
        if(super.getBalance() < amount)
            throw new LowBalanceException("Insufficient Funds: " + super.getBalance()
                                        + " for withdrawal amount: " + amount);
        double surcharge = 0.01 / 100;
        double newBalance = super.getBalance() - amount*(1+ surcharge);
        super.setBalance(newBalance);

        return amount;
    }
}
