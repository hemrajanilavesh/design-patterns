package com.lavesh.design.patterns.structural.decorator;

import java.util.function.Supplier;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/12/18
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Decorator of Shape with generics.
 * @param <T>
 */
class ColoredShape2 <T extends Shape> implements Shape {

    private Shape shape;
    private String color;

    public ColoredShape2(Supplier<? extends T> typ, String color) {
        this.shape = typ.get();
        this.color = color;
    }

    @Override
    public String info() {
        return this.shape.info() + " has color " + color;
    }
}

class TransparentShape2 <T extends Shape> implements Shape {

    private Shape shape;
    private int transparency;

    TransparentShape2(Supplier<? extends T> typ,int transparency) {
        this.shape = typ.get();
        this.transparency = transparency;
    }

    @Override
    public String info() {
        return this.shape.info() + " has transparency " + transparency + "%";
    }
}


public class StaticDecorator {
    public static void main(String[] args) {
        ColoredShape2 blueCircle = new ColoredShape2<>(() -> new Circle(10),"Blue");
        System.out.println(blueCircle.info());

        TransparentShape2 halfTransparentSquare = new TransparentShape2(() -> new Square(50), 50);
        System.out.println(halfTransparentSquare.info());

        TransparentShape2<ColoredShape2<Circle>> halfTransparentGreenCircle =
                new TransparentShape2<>(() ->
                        new ColoredShape2<Circle>(() -> new Circle(5), "green"), 50
                );
        System.out.println(halfTransparentGreenCircle.info());

    }
}
