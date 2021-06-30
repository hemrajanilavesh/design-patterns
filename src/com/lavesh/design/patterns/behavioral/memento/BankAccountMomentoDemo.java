package com.lavesh.design.patterns.behavioral.memento;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/15/18
 * Time: 9:14 PM
 * To change this template use File | Settings | File Templates.
 */

class TransactionToken {
    private int balance;

    TransactionToken(int balance) {
        this.balance = balance;
    }

    int getBalance() {
        return balance;
    }
}

class BankAccount {

    private int balance;

    public BankAccount() {
        this.balance = 0;
    }

    public TransactionToken deposit(int amount) {
        int prevBalance = this.balance;
        this.balance += amount;
        return new TransactionToken(prevBalance);
    }

    public TransactionToken withdraw(int amount) {
        int prevBalance = this.balance;
        if (this.balance >= amount) {
            this.balance -= amount;
        }
        return new TransactionToken(prevBalance);
    }

    public void restore(TransactionToken token) {
        this.balance = token.getBalance();
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }
}

public class BankAccountMomentoDemo {

    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        TransactionToken token1 =  ba.deposit(500); //500
        System.out.println(ba);
        TransactionToken token2 =  ba.withdraw(100);  // 400
        System.out.println(ba);
        TransactionToken token3 =  ba.deposit(300); // 700
        System.out.println(ba);
        TransactionToken token4 =  ba.withdraw(500); // 200
        System.out.println(ba);

        System.out.println("***Restoring account to before transaction 3***");
        ba.restore(token3);
        System.out.println(ba);

    }

}
