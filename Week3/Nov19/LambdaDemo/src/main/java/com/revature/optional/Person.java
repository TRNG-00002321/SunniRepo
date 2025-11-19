package com.revature.optional;

import java.util.Optional;

public class Person {
    String name;
    String phone;
    Address address;

    public Person(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    public Person(String name, String phone, Address address){
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getName(){return name;}
    public String getPhone(){return phone;}
    public Optional<Address> getAddress(){return Optional.ofNullable(address);}

    public void setName(String name){this.name = name;}
    public void setPhone(String phone){this.phone = phone;}
    public void setAddress(Address address){this.address = address;}

    @Override
    public String toString(){
        Optional<Address> optionalAddress = Optional.ofNullable(address);
        if (optionalAddress.isPresent())
            return getClass().getSimpleName() + "{%s, %s, %s}".formatted(name, phone, address);
        return getClass().getSimpleName() + "{%s, %s}".formatted(name, phone);
   }
}
