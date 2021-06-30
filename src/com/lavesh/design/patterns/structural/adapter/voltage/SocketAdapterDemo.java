package com.lavesh.design.patterns.structural.adapter.voltage;

public class SocketAdapterDemo {
    public static void main(String[] args) {
        ISocketAdapter iSocketAdapter = new SocketClassAdapterImpl();
        System.out.println("Socket Adapter Implementation using Inheritence.");
        System.out.println(iSocketAdapter.get3Volt());
        System.out.println(iSocketAdapter.get12Volt());
        System.out.println(iSocketAdapter.get120Volt());

        iSocketAdapter = new SocketObjectAdapterImpl();
        System.out.println("Socket Adapter Implementation using Composition.");
        System.out.println(iSocketAdapter.get3Volt());
        System.out.println(iSocketAdapter.get12Volt());
        System.out.println(iSocketAdapter.get120Volt());

    }
}
