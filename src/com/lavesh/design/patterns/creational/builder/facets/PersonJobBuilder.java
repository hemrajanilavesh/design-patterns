package com.lavesh.design.patterns.creational.builder.facets;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/9/18
 * Time: 7:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonJobBuilder extends PersonBuilder{
    public PersonJobBuilder(Person person) {
        this.person = person;
    }

    public PersonJobBuilder at(String companyName) {
        person.companyName = companyName;
        return this;
    }

    public PersonJobBuilder asA(String position) {
        person.position = position;
        return this;
    }

    public PersonJobBuilder earns(int annualIncome) {
        person.annualIncome = annualIncome;
        return this;
    }

}
