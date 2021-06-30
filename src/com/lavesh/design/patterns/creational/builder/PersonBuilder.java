package com.lavesh.design.patterns.creational.builder;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/9/18
 * Time: 6:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonBuilder <SELF extends PersonBuilder> {

    protected Person person = new Person();

    public SELF withName(String name) {
        person.name = name;
        return self();
    }

    public SELF self() {
        return (SELF)this;
    }

    public Person build() {
        return person;
    }

}
