package com.lavesh.design.patterns.behavioral.chain_of_responsibility.atm_dispenser;

public interface AtmDispenser {

    public static final int FIFTY = 50;
    public static final int TWENTY = 20;
    public static final int TEN = 10;

    void setNextAtmDispenser(AtmDispenser nextAtmDispenser);

    void dispense(Currency amount);

}
