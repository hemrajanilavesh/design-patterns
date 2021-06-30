package com.lavesh.design.patterns.interfaceseggregation;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/8/18
 * Time: 7:48 PM
 * To change this template use File | Settings | File Templates.
 */

/*
* Interface Segregation Principle
* ISP states that an interface should not define more than what the client expects
* if some clients require additional functionality create a separate interface
*
* */
public class ISPDemo {

         public static void main(String[] args) {
             Document doc = new Document("MyDoc");

             Printer p = new Printer();
             p.print(doc);

             Scanner s = new Scanner();
             s.scan(doc);

             XeroxMachine xerox = new XeroxMachine();
             xerox.print(doc);
             xerox.scan(doc);
         }
}
