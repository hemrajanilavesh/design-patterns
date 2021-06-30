package com.lavesh.design.patterns.creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/11/18
 * Time: 8:23 PM
 * To change this template use File | Settings | File Templates.
 */

enum EnumSingleton {
    INSTANCE;

    private int value;

    EnumSingleton() {
        value = 0;
    }

    int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }

}


public class EnumBasedSingleton {

    static void saveToFile(EnumSingleton singleton, String filename)
            throws Exception
    {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(singleton);
        }
    }

    static EnumSingleton readFromFile(String filename)
            throws Exception
    {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn) )
        {
            return (EnumSingleton)in.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        enumSingleton.setValue(16);
        //System.out.println(enumSingleton.getValue());

        String fileName = "enumSingleton.bin";
        saveToFile(enumSingleton, fileName);
        EnumSingleton enumSingleton2 = readFromFile(fileName);
        System.out.println(enumSingleton == enumSingleton2);


    }

}
