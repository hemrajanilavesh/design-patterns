package com.lavesh.design.patterns.structural.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/15/18
 * Time: 11:40 AM
 * To change this template use File | Settings | File Templates.
 */
interface Driveable {
    public void drive();
}

class Car implements Driveable {
    protected Driver driver;

    public Car(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void drive() {
        System.out.println("Car is being driven");
    }
}

class Driver {
    private int age;

    Driver(int age) {
        this.age = age;
    }

    int getAge() {
        return age;
    }
}

class CarProxy extends Car {

    public CarProxy(Driver driver) {
        super(driver);
    }

    @Override
    public void drive() {

        if (this.driver.getAge() < 18) {
            System.out.println("Driver is too young to drive.");
        } else {
            super.drive();    //To change body of overridden methods use File | Settings | File Templates.
        }
    }
}


public class ProtectionProxy {
    public static void main(String[] args) {
         CarProxy car = new CarProxy(new Driver(20));
        car.drive();
    }
}
