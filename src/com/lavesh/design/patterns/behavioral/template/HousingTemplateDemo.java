package com.lavesh.design.patterns.behavioral.template;

abstract class HousingTemplate {
    /**
     *  This is the template.
     *  Its final so that sub classes can't override.
     *  Template pattern is used when a fixed order is supposed to be followed.
     *  Here the underlying implementation can change. But order remains the same for all houses.
     */
    public final void buildHouse() {
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("House is built.");
    }

    public void buildWindows() {
        System.out.println("Building Windows.");
    }

    public abstract void buildWalls();

    public abstract void buildPillars();

    public void buildFoundation() {
        System.out.println("Building Foundation with cement, iron rods and sand.");
    }
}


class WoodenHouse extends HousingTemplate {

    @Override
    public void buildWalls() {
        System.out.println("Building Wooden Walls.");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with Wooden coating.");
    }
}

class GlassHouse extends HousingTemplate {

    @Override
    public void buildWalls() {
        System.out.println("Building Glass Walls.");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with Glass coating.");
    }
}


public class HousingTemplateDemo {
    public static void main(String[] args) {
        HousingTemplate glassHouse = new GlassHouse();
        glassHouse.buildHouse();
        System.out.println(System.lineSeparator());
        HousingTemplate woodenHouse = new WoodenHouse();
        woodenHouse.buildHouse();
    }
}
