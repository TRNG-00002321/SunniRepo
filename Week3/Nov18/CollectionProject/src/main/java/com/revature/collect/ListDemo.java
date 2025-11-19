package com.revature.collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
//        myList.add(1);
        myList.add("Sunni");
        myList.add("Alice");
        myList.add("Bob");

//        myList.add(3.14);

        System.out.println(myList.get(1));
        Iterator iterator = myList.iterator();

        while(iterator.hasNext())
            System.out.println(iterator.next());

        for(int i = 0; i < myList.size(); i++)
            System.out.println(myList.get(i));

        for(String string : myList)
            System.out.println(string);
    }
}

