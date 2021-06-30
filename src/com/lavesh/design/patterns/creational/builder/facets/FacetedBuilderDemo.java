package com.lavesh.design.patterns.creational.builder.facets;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/9/18
 * Time: 7:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class FacetedBuilderDemo {

    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        pb
                .lives()
                    .at("Wanawadi")
                    .in("Pune")
                    .withPostCode("411040")
                .works()
                    .asA("Developer")
                    .at("DB")
                    .earns(125000);

        System.out.println(pb.build());
    }
}
