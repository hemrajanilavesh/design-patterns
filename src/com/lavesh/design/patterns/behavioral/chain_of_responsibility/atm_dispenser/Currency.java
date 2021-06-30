package com.lavesh.design.patterns.behavioral.chain_of_responsibility.atm_dispenser;

public class Currency {

    private int amount;

    public Currency(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
