package com.revature.myio.jsonfiles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.myio.serialize.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class MultiObjJson {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        HashMap<Integer, Employee> employees = new HashMap<>();
        for(int i = 0; i < 5; i++){
            employees.put(i, new Employee(
                    i,
                    "Person" + i,
                    "Address" + i,
                    "Job" + i));
        }
        try (FileWriter fileWriter = new FileWriter("employees.json")) {
            gson.toJson(employees, fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
