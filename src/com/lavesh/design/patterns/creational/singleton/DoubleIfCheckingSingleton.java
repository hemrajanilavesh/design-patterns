package com.lavesh.design.patterns.creational.singleton;

/**
 * Demonstrates how to use double if checking to implement singleton
 * 1. Constructor should be private.
 * 2. Should contain a volatile instance of itself which is initially assigned to null.
 * 3. Have a static method to return the singleton object which is synchronized as performs double check.
 */


class Resource {

    private static /*volatile*/ Resource resource = null;

    public Resource() {
    }

    public static Resource getInstance() {
        System.out.println(Thread.currentThread().getName() + " is trying to initialize the resource.");
        if (resource == null) {
            synchronized (Resource.class) {
                if (resource == null) {
                    System.out.println("***" + Thread.currentThread().getName() + " has initialized the resource.***");
                    resource = new Resource();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " has received the resource.");
        return resource;
    }
}


public class DoubleIfCheckingSingleton {

    public static void main(String[] args) {
        Thread t1 = new Thread(Resource::getInstance); t1.start();
        Thread t2 = new Thread(Resource::getInstance); t2.start();
        Thread t3 = new Thread(Resource::getInstance); t3.start();
        Thread t4 = new Thread(Resource::getInstance); t4.start();
    }

}
