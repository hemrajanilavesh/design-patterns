package com.lavesh.design.patterns.creational.builder.computer;

public class ComputerBuidlerDemo {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder()
                .withBluetoothEnabled(true)
                .withGraphicsCardEnabled(true)
                .withHDD("250 GB")
                .withRam("8G B").build();
        System.out.println(computer);
    }
}
