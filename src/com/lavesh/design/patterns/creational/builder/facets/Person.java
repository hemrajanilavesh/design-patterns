package com.lavesh.design.patterns.creational.builder.facets;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/9/18
 * Time: 7:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person {
    //address
    String streetAddress, postalCode, city;
    //employment
    String companyName, position;
    //income
    int annualIncome;

    @Override
    public String toString() {
        return "Person{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}
