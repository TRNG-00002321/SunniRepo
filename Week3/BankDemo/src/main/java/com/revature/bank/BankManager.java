package com.revature.bank;

public class BankManager {
    public static void main(String[] args) {
//        BankAccount b1 = new BankAccount("B001", "Alice", 5000);
        SavingAccount s1 = new SavingAccount("S001", "Bob", 10000);
        CheckingAccount c1 = new CheckingAccount("C001", "Charlie", 15000);

        System.out.println(s1);
        double money = s1.withdraw(1000);
        System.out.println("Withdrawn: " + money);
        System.out.println(s1);
        System.out.println("Interest: " + s1.calculateInterest(5));
        System.out.println(s1);


        System.out.println(c1);
        money = c1.withdraw(1000);
        System.out.println("Withdrawn: " + money);
        System.out.println(c1);
    }
}
