package com.lavesh.design.patterns.behavioral.chain_of_responsibility.atm_dispenser;

public class FiftyDollarAtmDispenser implements AtmDispenser {

    private AtmDispenser nextAtmDispenser;

    @Override
    public void setNextAtmDispenser(AtmDispenser nextAtmDispenser) {
        this.nextAtmDispenser = nextAtmDispenser;
    }

    @Override
    public void dispense(Currency amount) {
          if (amount.getAmount() >= FIFTY) {
              int amountBeforeProcessing = amount.getAmount();
              int multiples = amountBeforeProcessing / FIFTY;
              System.out.println("Dispensing " + multiples + " notes of $50.");
              int remainingAmount = amountBeforeProcessing % FIFTY;
              if (remainingAmount >= TEN) {
                  this.nextAtmDispenser.dispense(new Currency(remainingAmount));
              }
          } else {
              this.nextAtmDispenser.dispense(amount);
          }
    }
}
