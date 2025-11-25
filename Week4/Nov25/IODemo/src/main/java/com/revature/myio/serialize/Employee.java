package com.revature.myio.serialize;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 3348806719900290819L;
    private int empID;
    private String empName;
    private String address;
    private transient String jobTitle;

    public Employee() {
    }
    public Employee(int empID, String empName, String address, String jobTitle) {
        this.empID = empID;
        this.empName = empName;
        this.address = address;
        this.jobTitle = jobTitle;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", address='" + address + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
