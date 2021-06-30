package com.lavesh.design.patterns.behavioral.strategy;

public class CreditCardStrategy implements PaymentStrategy {

    private int creditCardNumber;
    private int cvv;
    private String ownerName;
    private String dateOfExpiry;

    public CreditCardStrategy(int creditCardNumber, int cvv, String ownerName, String dateOfExpiry) {
        this.creditCardNumber = creditCardNumber;
        this.cvv = cvv;
        this.ownerName = ownerName;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying Rs." + amount + " using Credit Card.");
    }
}
