package com.revature.employee;

public class EmployeeManager {
    public static void main(String[] args) {
        SalariedEmployee e1 = new SalariedEmployee("Alice", 16, 5);
        ContractEmployee e2 = new ContractEmployee("Bob", 2, 40);
        System.out.println(e1);
        System.out.println(e2);
        e1.displayBenefits();
    }

}
