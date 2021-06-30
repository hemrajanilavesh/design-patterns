package com.lavesh.design.patterns.creational.singleton;

/**
 * This is the Bill Pugh method of creating a singleton instance using inner static helper class.
 * It is thread safe. No need to use synchronized block / methods.
 * This is the most widely used approach.
 */
public class BillPughSingleton {


    public static void main(String[] args) {
        BillPughSingleton instanceOne = BillPughSingleton.SingletonHelper.getBillPughSingleton();
        BillPughSingleton instanceTwo = BillPughSingleton.SingletonHelper.getBillPughSingleton();
        System.out.println(instanceOne == instanceTwo);
    }

    /**
     * Since this is singleton object, it does not support cloning.
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    private static class SingletonHelper {

        private static final BillPughSingleton billPughSingleton = new BillPughSingleton();

        private SingletonHelper() {
        }

        public static BillPughSingleton getBillPughSingleton() {
            return billPughSingleton;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }


}
