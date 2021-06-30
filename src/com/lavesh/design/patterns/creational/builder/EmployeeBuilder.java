package com.lavesh.design.patterns.creational.builder;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/9/18
 * Time: 6:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {

    public EmployeeBuilder worksAs(String position) {
        person.position =  position;
        return self();
    }

    @Override
    public EmployeeBuilder self() {
        return this;
    }
}
