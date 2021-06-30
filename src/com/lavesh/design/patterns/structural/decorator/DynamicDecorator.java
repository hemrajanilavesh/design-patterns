package com.lavesh.design.patterns.structural.decorator;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/12/18
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */

interface Shape{
    public String info();
}

class Circle implements Shape {

    public float radius;

    Circle(){}

    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public String info() {
        return "A Circle with radius " + radius;
    }
}

class Square implements Shape {
    public int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public String info() {
        return "A Square with side " + side;
    }
}

/**
 * Decorator of Shape.
 * Extends the functionality of shape by adding color attribute
 */
class ColoredShape implements Shape {

    private Shape shape;
    private String color;

    public ColoredShape(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String info() {
        return this.shape.info() + " has color " + color;
    }
}
/**
 * Decorator of Shape.
 * Extends the functionality of shape by adding transparency attribute
 */
class TransparentShape implements Shape {
    private Shape shape;
    private int transparency;

    TransparentShape(Shape shape, int transparency) {
        this.shape = shape;
        this.transparency = transparency;
    }

    @Override
    public String info() {
        return this.shape.info() + " has transparency " + transparency + "%";
    }
}

public class DynamicDecorator {

    public static void main(String[] args) {
        ColoredShape blueCircle = new ColoredShape(new Circle(10),"Blue");
        System.out.println(blueCircle.info());

        TransparentShape halfTransparentSquare = new TransparentShape(new Square(50), 50);
        System.out.println(halfTransparentSquare.info());
    }

}
