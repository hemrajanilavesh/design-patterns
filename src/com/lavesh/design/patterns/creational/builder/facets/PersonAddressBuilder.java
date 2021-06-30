package com.lavesh.design.patterns.creational.builder.facets;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/9/18
 * Time: 7:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonAddressBuilder extends PersonBuilder {

    public PersonAddressBuilder(Person person) {
        this.person = person;
    }

    public PersonAddressBuilder at(String streetAddress) {
        person.streetAddress = streetAddress;
        return this;
    }

    public PersonAddressBuilder in(String city) {
        person.city = city;
        return this;
    }

    public PersonAddressBuilder withPostCode(String postCode) {
        person.postalCode = postCode;
        return this;
    }

}
