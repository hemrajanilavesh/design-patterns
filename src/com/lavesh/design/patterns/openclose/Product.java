package com.lavesh.design.patterns.openclose;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/7/18
 * Time: 8:47 PM
 * To change this template use File | Settings | File Templates.
 */

enum Color {
    RED, GREEN, BLUE
}

enum Size {
    SMALL, MEDIUM, LARGE
}

public class Product {

     String name;
    Color color;
     Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", size=" + size +
                '}';
    }
}
