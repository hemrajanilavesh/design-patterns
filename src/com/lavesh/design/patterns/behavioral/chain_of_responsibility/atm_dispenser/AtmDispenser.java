package com.lavesh.design.patterns.behavioral.chain_of_responsibility.atm_dispenser;

public interface AtmDispenser {

    int FIFTY = 50;
    int TWENTY = 20;
    int TEN = 10;

    void setNextAtmDispenser(AtmDispenser nextAtmDispenser);

    void dispense(Currency amount);

}
