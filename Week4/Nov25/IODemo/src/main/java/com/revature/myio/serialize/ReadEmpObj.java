package com.revature.myio.serialize;

import java.io.*;

public class ReadEmpObj {
    public static void main(String[] args) {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        try{
            fileInputStream = new FileInputStream("employee.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);
            Employee employee = (Employee) objectInputStream.readObject();
            System.out.println(employee);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
