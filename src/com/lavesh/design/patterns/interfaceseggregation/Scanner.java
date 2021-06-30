package com.lavesh.design.patterns.interfaceseggregation;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/8/18
 * Time: 7:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Scanner implements IScanner {
    @Override
    public void scan(Document d) {
        System.out.println("Scanning document using simple scanner:" + d.name);
    }
}
