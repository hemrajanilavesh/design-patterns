package com.lavesh.design.patterns.creational.factory;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/11/18
 * Time: 10:53 AM
 * To change this template use File | Settings | File Templates.
 */

/**
 * In factory design pattern, we don't want to expose the object creation logic to the client.
 * In the below example, the methods createCartesianPoint & createPolarPoint do not expose how point is created.
 */

class Point {

    public double x,y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point createCartesianPoint(double x, double y) {
        return new Point(x,y);
    }

    public static Point createPolarPoint(double rho, double theta) {
        return new Point(rho*Math.cos(theta), rho* Math.sin(theta));
    }

}


public class FactoryMethod {

    public static void main(String[] args) {
        Point cp = Point.createCartesianPoint(1,1);
        Point pp = Point.createPolarPoint(2,2.5);
    }

}
