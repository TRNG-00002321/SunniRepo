package com.revature.optional;

public class Address {
    private String street;
    private String city;
    private int zipcode;

    public Address(String street, String city, int zipcode){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String getStreet(){return this.street;}
    public String getCity(){return this.city;}
    public int getZip(){return this.zipcode;}

    public  void setStreet(String street){this.street = street;}
    public void setCity(String city){this.city = city;}
    public void setZipcode(int zipcode){this.zipcode = zipcode;}


    public String toString(){
        return getClass().getSimpleName() + "{%s,  %s, %d}".formatted(street, city, zipcode);
    }
}
