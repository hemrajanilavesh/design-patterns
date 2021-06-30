package com.lavesh.design.patterns.interfaceseggregation;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/8/18
 * Time: 7:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Document {
    String name;
    String text;

    public Document(String name) {
        this.name = name;
        this.text = "";
    }

    public void setText(String text) {
        this.text = text;
    }
}
