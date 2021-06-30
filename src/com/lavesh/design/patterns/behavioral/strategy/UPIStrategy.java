package com.lavesh.design.patterns.behavioral.strategy;

public class UPIStrategy implements PaymentStrategy {

    private String upiID;
    private int upiPIN;

    public UPIStrategy(String upiID, int upiPIN) {
        this.upiID = upiID;
        this.upiPIN = upiPIN;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying Rs." + amount + " using UPI.");
    }
}
