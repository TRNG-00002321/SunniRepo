package com.revature.lambda;

public class HelloDemo {
    public static void main(String[] args) {
        Hello h;
//        h = () -> System.out.println("Hello");
//        h.hello();

//        h = (name) ->System.out.println("Hello " + name);
//        h.hello("Sunni");

        h = (fname, lname) -> System.out.println("Hello " + fname + " " + lname);
        h.hello("Sunni", "Magan");


    }
}
