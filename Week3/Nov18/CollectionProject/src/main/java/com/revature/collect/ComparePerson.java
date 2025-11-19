package com.revature.collect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparePerson {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(0, "Ella", 767658));
        personList.add(new Person(2, "Dan", 876876));
        personList.add(new Person(3, "Charlie", 52276521));
        personList.add(new Person(1, "Bob", 357654));
        personList.add(new Person(4, "Alice", 76532));

        System.out.println(personList);
        Collections.sort(personList);
        System.out.println(personList);
        Collections.sort(personList, Comparator.comparing(Person::getSalary));
        System.out.println(personList);
        Collections.sort(personList, Comparator.comparing(Person::getName));
        System.out.println(personList);

    }
}
