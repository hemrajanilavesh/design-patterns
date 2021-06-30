package com.lavesh.design.patterns.creational.builder;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/9/18
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class FluentBuilderDemo {

    public static void main(String[] args) {
        HtmlBuilder builder = new HtmlBuilder("ul");
        builder
                .addFluentChild("li","Hello")
                .addFluentChild("li","World");
        System.out.println(builder);
    }
}
