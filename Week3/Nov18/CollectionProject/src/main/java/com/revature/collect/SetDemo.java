package com.revature.collect;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> names = new LinkedHashSet<>();

        names.add("Andrew");
        names.add("Ian");
        names.add("Brandon");
        names.add("Andrew");

        System.out.println(names);

        for(String name : names)
            System.out.println(name);

        String sentence = "The Quick Brown Fox Jumped Over The Lazy Dog";
        Set<Character> letters;
//        letters = new LinkedHashSet<>();
//        letters = new HashSet<>();
        letters = new TreeSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            letters.add(sentence.charAt(i));
        }
        Set<Character> oddLetters = new HashSet<>();
        oddLetters.addAll(letters);
        Iterator it = letters.iterator();
        for(int i = 0; i < letters.size(); i +=2)
            oddLetters.remove(it.next());
        letters.removeAll(oddLetters);

        System.out.println(letters);

    }
}
