package com.lavesh.design.patterns.behavioral.chain_of_responsibility.atm_dispenser;

public class TenDollarAtmDispenser implements AtmDispenser {

    private AtmDispenser nextAtmDispenser;

    @Override
    public void setNextAtmDispenser(AtmDispenser nextAtmDispenser) {
        this.nextAtmDispenser = nextAtmDispenser;
    }

    @Override
    public void dispense(Currency amount) {
        if (amount.getAmount() >= TEN) {
            int amountBeforeProcessing = amount.getAmount();
            int multiples = amountBeforeProcessing / TEN;
            System.out.println("Dispensing " + multiples + " notes of $10.");
        } else if (this.nextAtmDispenser != null) {
            this.nextAtmDispenser.dispense(amount);
        }

    }
}
