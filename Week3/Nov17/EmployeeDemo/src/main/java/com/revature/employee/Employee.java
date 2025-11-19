package com.revature.employee;

public abstract class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double salary){
        this.name = name;
        this.baseSalary = salary;
    }

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public double getSalary(){return baseSalary;}
    public void setSalary(double salary){this.baseSalary = salary;}

    @Override
    public String toString(){
        return getClass().getSimpleName() + "{" +
                "name: " + name + ", " +
                "salary: " + this.getSalary() + "}";
    }
}
