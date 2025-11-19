package com.revature.collect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Brandon");
        names.add("Alex");
        names.add("Peter");
        names.add("Nikhil");

        System.out.println(names);

        Collections.sort(names);
        System.out.println(names);

    }
}
