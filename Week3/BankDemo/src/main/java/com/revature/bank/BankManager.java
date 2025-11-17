package com.revature.bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankManager {

    public static char getChar(String prompt){
        Scanner input = new Scanner(System.in);
        char character;
        while (true) {
            try {
                System.out.print(prompt);
                character = input.next().charAt(0);
                return character;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static char getAccountType() {
        char accountType;
        do {
            accountType = getChar("Enter account type (S)avings or (C)hecking: ");
        } while (accountType != 'S' && accountType != 'C');
        return accountType;
    }

    public static char getTransactionType() {
        char transactionType;
        do {
            transactionType = getChar("Enter transaction type (W)ithdraw or (D)eposit: ");
        } while (transactionType != 'W' && transactionType != 'D');
        return transactionType;
    }

    public static double getAmount() {
        Scanner input = new Scanner(System.in);
        double amount = input.nextDouble();
        input.close();
        return amount;
    }

    public static void main(String[] args) {
        SavingAccount s1 = new SavingAccount("S001", "Bob", 10000);
        CheckingAccount c1 = new CheckingAccount("C001", "Charlie", 15000);
            BankAccount b;
            System.out.println(s1);
            System.out.println(c1);
            char accountType = getAccountType();
            if (accountType == 'S')
                b = s1;
            else
                b = c1;
            char transactionType = getTransactionType();
            double amount;
            if (transactionType == 'W') {
                System.out.print("Enter amount to withdraw: ");
                amount = getAmount();
                b.withdraw(amount);
            } else {
                System.out.print("Enter amount to deposit: ");
                amount = getAmount();
                b.deposit(amount);
            }
            System.out.println(s1);
            System.out.println(c1);
    }


//        System.out.println(s1);
//        double money = s1.withdraw(1000);
//        System.out.println("Withdrawn: " + money);
//        System.out.println(s1);
//        System.out.println("Interest: " + s1.calculateInterest(5));
//        System.out.println(s1);
//
//
//        System.out.println(c1);
//        money = c1.withdraw(1000);
//        System.out.println("Withdrawn: " + money);
//        System.out.println(c1);
}
