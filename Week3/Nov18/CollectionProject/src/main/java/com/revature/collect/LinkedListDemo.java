package com.revature.collect;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        List<String> myList = new LinkedList<>();

        myList.add("Quick");
        myList.add("Brown");
        myList.add(0, "The");
        String fox = "Fox";
        if(! myList.contains(fox))
            myList.add(fox);
        System.out.println(myList);
        String[] sentence = {"Jumped", "Over", "The", "Lazy", "Dog"};
        List<String> newList = new LinkedList<>();
        for(String word : sentence)
            newList.add(word);

        System.out.println(newList);
        myList.addAll(newList);
        System.out.println(myList);

        newList.clear();
        System.out.println(newList);
        while(!myList.isEmpty()) {
            String word = myList.remove(0);
            newList.add(word);
        }
        System.out.println(newList);

        for(int i = newList.size()-1; i >= 0; i--)
            System.out.println(newList.get(i));
        System.out.println();
        Iterator it =newList.iterator();
        while (it.hasNext())
            System.out.println(it.next());


    }
}
