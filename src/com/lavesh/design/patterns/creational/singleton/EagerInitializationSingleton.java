package com.lavesh.design.patterns.creational.singleton;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/11/18
 * Time: 7:22 PM
 * To change this template use File | Settings | File Templates.
 */

// Singletons can be violated by
   // 1. Reflections
   // 2. Serialization
class BasicSingleton implements Serializable {

    private int value = 0;

    public static final BasicSingleton INSTANCE = new BasicSingleton();

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private BasicSingleton() {
        System.out.println("Singleton is initialized.");
    }

    // add synchronized to this method for multi-threaded environments
    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    // readResolve is used to tell JVM to replace de-serialized object with singleton instance
    // it is a way to protect duplicate object creation using serialization
     protected Object readResolve() {
         return INSTANCE;
     }
}

public class EagerInitializationSingleton {

    static void saveToFile(BasicSingleton singleton, String filename)
            throws Exception
    {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(singleton);
        }
    }

    static BasicSingleton readFromFile(String filename)
            throws Exception
    {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn) )
        {
            return (BasicSingleton)in.readObject();
        }
    }


    public static void main(String[] args) throws Exception {
        String filename = "singleton.bin";
        BasicSingleton instance = BasicSingleton.getInstance();
        saveToFile(instance,filename);

        BasicSingleton instance2 = readFromFile(filename);
        instance2.setValue(222);
        System.out.println(instance == instance2);   // this should be true

        System.out.println(instance.getValue());
        System.out.println(instance2.getValue());
    }
}
