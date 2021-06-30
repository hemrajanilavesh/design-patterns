package com.lavesh.design.patterns.creational.singleton;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/11/18
 * Time: 9:07 PM
 * To change this template use File | Settings | File Templates.
 */

/*
* Monostate pattern can be implemented by keeping all the attributes of a class as static and private
* no matter how many instances of the class are created, the attributes will be shared across instances
*
* */

class ChiefExecutiveOfficer {

    private static String name;
    private static int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        ChiefExecutiveOfficer.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        ChiefExecutiveOfficer.age = age;
    }

    @Override
    public String toString() {
        return "ChiefExecutiveOfficer{" + this.getName() + " , " + this.getAge() + "}";
    }
}

public class Monostate {

    public static void main(String[] args) {

        ChiefExecutiveOfficer ceo = new ChiefExecutiveOfficer();
        ceo.setName("Lavesh Hemrajani");
        ceo.setAge(25);

        ChiefExecutiveOfficer ceo2 = new ChiefExecutiveOfficer();
        System.out.println(ceo2.toString());
    }

}
