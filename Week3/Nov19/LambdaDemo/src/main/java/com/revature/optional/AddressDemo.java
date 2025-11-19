package com.revature.optional;

public class AddressDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", "555-555-5555");
        Person p2 = new Person(
                "Bob",
                "555-555-5555",
                new Address("Legacy Dr", "Plano, TX", 75098));

        System.out.print("Address of p1: ");
        if(p1.getAddress().isPresent())
             System.out.println( p1.getAddress().get());
        else System.out.println("None");

        System.out.print("Address of p2: ");
        if(p2.getAddress().isPresent())
             System.out.println(p2.getAddress().get());
        else System.out.println("None");
//        System.out.println("Address of p2: " + p2.getAddress().get());

        System.out.println(p1);
        System.out.println(p2);


    }
}
