package com.revature.myio.jsonfiles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.myio.serialize.Employee;

import java.io.FileWriter;
import java.io.IOException;

public class JsonIO {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        Employee employee = new Employee(231, "Sunni", "Plano", "QEA");
        try (FileWriter fileWriter = new FileWriter("employee.json")) {
            gson.toJson(employee, fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
