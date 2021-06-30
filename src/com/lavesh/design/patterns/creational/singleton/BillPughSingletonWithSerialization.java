package com.lavesh.design.patterns.creational.singleton;

import java.io.*;

/**
 * This is the Bill Pugh method of creating a singleton instance using inner static helper class.
 * It is thread safe. No need to use synchronized block / methods.
 * This is the most widely used approach.
 */
public class BillPughSingletonWithSerialization implements Serializable {

    static void saveToFile(BillPughSingletonWithSerialization singleton, String filename)
            throws Exception
    {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(singleton);
        }
    }

    static BillPughSingletonWithSerialization readFromFile(String filename)
            throws Exception
    {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn) )
        {
            return (BillPughSingletonWithSerialization)in.readObject();
        }
    }

    /**
     * This method enforeces singleton pattern in serialized objects.
     * If this method is not present, java will create new instance on de-serialization.
     * @return
     */
    protected Object readResolve() {
        return BillPughSingletonWithSerialization.SingletonHelper.getBillPughSingleton();
    }

    public static void main(String[] args) throws Exception {
        String fileName = "billpughobject.bin";
        BillPughSingletonWithSerialization instanceOne = BillPughSingletonWithSerialization.getInstance();
        saveToFile(instanceOne, fileName);
        BillPughSingletonWithSerialization instanceTwo = readFromFile(fileName);
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

    public static BillPughSingletonWithSerialization getInstance() {
        return SingletonHelper.billPughSingleton;
    }


    public static class SingletonHelper {
        // this instance gets created when getBillPughSingleton() is called, because only then SingletonHelper class is loaded into memory.
        private static final BillPughSingletonWithSerialization billPughSingleton = new BillPughSingletonWithSerialization();

        private SingletonHelper() {
        }

        public static BillPughSingletonWithSerialization getBillPughSingleton() {
            return billPughSingleton;
        }
    }


}
