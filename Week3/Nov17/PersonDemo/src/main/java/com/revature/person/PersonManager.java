package com.revature.person;

public class PersonManager {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 25);
        System.out.println("Person 1: " + p1);
        Person p2 = new Person();
        p2.setName("Alice");
        p2.setAge(25);
        if (p1.equals(p2))
            System.out.println("Equal");
        else
            System.out.println("Not Equal");

    }
}
