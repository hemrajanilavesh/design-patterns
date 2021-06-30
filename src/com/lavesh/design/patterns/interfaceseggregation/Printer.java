package com.lavesh.design.patterns.interfaceseggregation;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/8/18
 * Time: 7:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Printer implements IPrinter {
    @Override
    public void print(Document d) {
        System.out.println("Printing document using simple printer:" + d.name);
    }
}
