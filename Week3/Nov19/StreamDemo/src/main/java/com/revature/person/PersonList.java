package com.revature.person;

import java.util.ArrayList;
import java.util.List;

public class PersonList {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        int n = 10;
        char letter = 'A';
        String name = "Person ";
        int salary = 100;
        for(int i = 0; i < n; i++){
            personList.add(new Person(i, name + letter++, salary*=2));
        }

        for(Person person: personList)
            System.out.println(person);

        System.out.println();
        personList.forEach(person -> System.out.println(person));

        personList.stream()
                .map(p -> p.getName().toUpperCase())
                .forEach(pName -> System.out.println(pName));

        List<Person> newPersons =
                personList.stream()
                        .filter(p -> p.getSalary() > 10000)
                        .collect(
                                () -> new ArrayList<>(),
                                (c, e) -> c.add(e),
                                (c1, c2) -> c1.addAll(c2));
        System.out.println(newPersons);




    }
}
