package com.lavesh.design.patterns.interfaceseggregation;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/8/18
 * Time: 7:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class XeroxMachine implements PrinterScannerMachine {
    @Override
    public void print(Document d) {
        System.out.println("Printing document using PrinterScanner:" + d.name);
    }

    @Override
    public void scan(Document d) {
        System.out.println("Scanning document using PrinterScanner:" + d.name);
    }
}
