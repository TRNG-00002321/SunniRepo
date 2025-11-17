package com.revature.employee;

public class ContractEmployee extends Employee{

    private int hoursWorked;

    public ContractEmployee(String name, double baseSalary, int hoursWorked){
        super(name, baseSalary);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double getSalary(){
        return super.getSalary()*hoursWorked;
    }

    public int getHoursWorked(){
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked){
        this.hoursWorked = hoursWorked;
    }
}
