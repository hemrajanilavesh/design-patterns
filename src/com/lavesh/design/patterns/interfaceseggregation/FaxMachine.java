package com.lavesh.design.patterns.interfaceseggregation;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/8/18
 * Time: 7:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class FaxMachine implements IFax {
    @Override
    public void fac(Document d) {
        System.out.println("Fax document :" + d.name);
    }
}
