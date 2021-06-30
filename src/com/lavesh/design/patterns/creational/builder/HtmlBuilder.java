package com.lavesh.design.patterns.creational.builder;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/9/18
 * Time: 6:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class HtmlBuilder {
    String rootName;
    HtmlElement root = new HtmlElement();

    public HtmlBuilder(String rootName) {
        this.rootName = rootName;
        root.name = rootName;
    }

    public void addChild(String childName, String childText) {
        HtmlElement e = new HtmlElement(childName, childText);
        root.elements.add(e);
    }

    // fluent builder
    // change return type of add method to builder
    public HtmlBuilder addFluentChild(String childName, String childText) {
        HtmlElement e = new HtmlElement(childName,childText);
        root.elements.add(e);
        return this;
    }

    @Override
    public String toString() {
        return root.toString();
    }

    public void clear() {
        root = new HtmlElement();
        root.name = rootName;
    }
}
