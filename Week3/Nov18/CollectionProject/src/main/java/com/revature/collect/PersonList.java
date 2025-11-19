package com.revature.collect;

import java.util.ArrayList;
import java.util.List;

public class PersonList {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        int n = 5;
        char letter = 'A';
        String name = "Person ";
        int age = 50;
        for(int i = 0; i < n; i++){
            personList.add(new Person(i, name + letter++, age++));
        }
        for(Person person: personList)
            System.out.println(person);
    }
}
