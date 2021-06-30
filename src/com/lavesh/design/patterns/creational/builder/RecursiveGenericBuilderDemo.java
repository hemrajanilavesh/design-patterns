package com.lavesh.design.patterns.creational.builder;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/9/18
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class RecursiveGenericBuilderDemo {

    public static void main(String[] args) {
        EmployeeBuilder eb = new EmployeeBuilder();
        eb
                .withName("Lavesh")
                .worksAs("Senior Analyst");
        System.out.println(eb.build().toString());
    }
}
