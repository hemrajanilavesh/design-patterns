package com.lavesh.design.patterns.behavioral.chain_of_responsibility.atm_dispenser;

import java.util.Scanner;

public class AtmDispenserChain {

    private AtmDispenser fifty;

    public AtmDispenserChain() {
        fifty = new FiftyDollarAtmDispenser();

        AtmDispenser twenty = new TwentyDollarAtmDispenser();
        fifty.setNextAtmDispenser(twenty);

        AtmDispenser ten = new TenDollarAtmDispenser();
        twenty.setNextAtmDispenser(ten);
        ten.setNextAtmDispenser(null);
    }

    public static void main(String[] args) {
        AtmDispenserChain atmDispenserChain = new AtmDispenserChain();

        Scanner scanner = new Scanner(System.in);
        int amountToBeDispensed = 0;
        while (true) {
            System.out.println("Enter amount to be dispensed in the multiples of $10");
            amountToBeDispensed = scanner.nextInt();
            if (amountToBeDispensed % 10 == 0) {
                atmDispenserChain.fifty.dispense(new Currency(amountToBeDispensed));
            } else {
                System.out.println("Invalid Amount!");
            }
        }


    }
}
