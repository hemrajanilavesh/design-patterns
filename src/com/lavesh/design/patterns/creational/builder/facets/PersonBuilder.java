package com.lavesh.design.patterns.creational.builder.facets;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/9/18
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonBuilder {

    protected Person person = new Person();

    public PersonAddressBuilder lives() {
        return new PersonAddressBuilder(person);
    }
    public PersonJobBuilder works() {
        return new PersonJobBuilder(person);
    }

    public Person build() {
        return person;
    }
}
