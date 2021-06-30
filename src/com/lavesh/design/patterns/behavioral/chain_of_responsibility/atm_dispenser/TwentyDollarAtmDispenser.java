package com.lavesh.design.patterns.behavioral.chain_of_responsibility.atm_dispenser;

public class TwentyDollarAtmDispenser implements AtmDispenser {



    private AtmDispenser nextAtmDispenser;

    @Override
    public void setNextAtmDispenser(AtmDispenser nextAtmDispenser) {
        this.nextAtmDispenser = nextAtmDispenser;
    }

    @Override
    public void dispense(Currency amount) {
        if (amount.getAmount() >= TWENTY) {
            int amountBeforeProcessing = amount.getAmount();
            int multiples = amountBeforeProcessing / TWENTY;
            System.out.println("Dispensing " + multiples + " notes of $20.");
            int remainingAmount = amountBeforeProcessing % TWENTY;
            if (remainingAmount >= TEN) {
                this.nextAtmDispenser.dispense(new Currency(remainingAmount));
            }
        } else {
            this.nextAtmDispenser.dispense(amount);
        }

    }
}
