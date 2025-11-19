package com.revature.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Double> persons = new HashMap<>();
        persons.put("Alex", 100000.00);
        persons.put("Rebecca", 250000.00);
        persons.put("Peter", 200000.00);
//        persons.put("Alex", 150000.00);

        System.out.println(persons.get("Alex"));
        Set<String> names = persons.keySet();
        for(String name: names)
            System.out.println(name + ", " + persons.get(name));
    }
}
