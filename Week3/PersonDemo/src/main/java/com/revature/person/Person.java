package com.revature.person;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person(){}

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
    public int getAge(){return this.age;}
    public void setAge(int age){this.age = age;}

    @Override
    public boolean equals(Object o){
        if(o == null || getClass() != o.getClass()) return false;
        Person p = (Person) o;
        return age == p.age && Objects.equals(name, p.name);
    }
    @Override
    public int hashCode(){
        return Objects.hashCode(name);
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

