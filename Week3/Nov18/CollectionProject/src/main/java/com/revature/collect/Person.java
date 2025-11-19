package com.revature.collect;

public class Person implements Comparable<Person> {
    private int id;
    private String name;
    private int salary;
    public Person(){
        id = 0;
        name = "";
        salary = 0;
    }
    public Person(int id, String name, int salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + String.format("{%d, '%s', %d}", id, name, salary);
    }

    @Override
    public int compareTo(Person p) {
        if(this.id < p.id)
            return -1;
        else if(this.id == p.id)
            return 0;
        return 1;
    }
}
