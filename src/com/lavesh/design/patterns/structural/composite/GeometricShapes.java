package com.lavesh.design.patterns.structural.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/12/18
 * Time: 12:09 PM
 * To change this template use File | Settings | File Templates.
 */

class GraphicObject {

    String name = "Group";
    public String color;
    public List<GraphicObject> children = new ArrayList<>();

    public GraphicObject() {
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public void print(StringBuilder stringBuilder, int depth) {
        stringBuilder.append(String.join("", Collections.nCopies(depth, "*")))
                .append(depth > 0 ? " " : "")
                .append((color == null || color.isEmpty()) ? "" : color + " ")
                .append(getName())
                .append(System.lineSeparator());
        for (GraphicObject child : children)
            child.print(stringBuilder,  depth+1);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        print(sb,0);
        return sb.toString();
    }
}

class Square extends GraphicObject {

    public Square(String color) {
        this.name = "Square";
        this.color = color;
    }
}

class Circle extends GraphicObject {

    public Circle(String color) {
        this.name = "Circle";
        this.color = color;
    }
}

public class GeometricShapes {

    public static void main(String[] args) {
        GraphicObject drawing = new GraphicObject();
        drawing.setName("My Drawing");
        drawing.children.add(new Square("Red"));
        drawing.children.add(new Circle("Yellow"));

        GraphicObject group = new GraphicObject();
        group.children.add(new Circle("Blue"));
        group.children.add(new Square("Blue"));
        drawing.children.add(group);

        System.out.println(drawing);
    }

}
