package com.lavesh.design.patterns.creational.prototype;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/11/18
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
 */

class Address {
    public String street, city, country;

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    //copy constructor for Adress


    public Address(Address other) {
        this(other.street,other.city,other.country);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

class Employee {

    public String name;
    public Address adress;

    public  Employee(String name, Address adress) {
        this.name = name;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public Address getAdress() {
        return adress;
    }

    public Employee(Employee other) {
        this(other.name, other.adress);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", adress=" + adress +
                '}';
    }
}


public class CopyConstructors {

    public static void main(String[] args) {
        Employee john = new Employee("John", new Address("London Road", "London", "UK"));

        Employee chris = new Employee(john);
        chris.name = "Chris";
        System.out.println(john);
        System.out.println(chris);

        chris.getAdress().setCity("Manchester City");

        System.out.println(john);
        System.out.println(chris);

    }

}
