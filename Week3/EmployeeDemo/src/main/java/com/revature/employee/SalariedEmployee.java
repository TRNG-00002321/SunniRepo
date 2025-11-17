package com.revature.employee;

public class SalariedEmployee extends Employee implements Benefits{
    int daysWorked;

    public SalariedEmployee(String name, double baseSalary, int daysWorked){
        super(name, baseSalary);
        this.daysWorked = daysWorked;
    }

    @Override
    public double getSalary(){
        return super.getSalary() * daysWorked;
    }

    public int getDaysWorked(){
        return daysWorked;
    }

    public void setDaysWorked(int daysWorked){
        this.daysWorked = daysWorked;
    }

    @Override
    public void displayBenefits() {
        String[] benefits = {"food coupons", "payed time-off"};
        System.out.println("Benefits: ");
        for (String benefit: benefits){
            System.out.println("- " +  benefit);
        }
    }
}
