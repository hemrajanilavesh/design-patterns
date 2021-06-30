package com.lavesh.design.patterns.behavioral.null_object;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/16/18
 * Time: 10:12 AM
 * To change this template use File | Settings | File Templates.
 */

interface Log {
    void info(String msg);
    void warn(String msg);
}

class ConsoleLog implements Log {
    @Override
    public void info(String msg) {
        System.out.println(msg);
    }

    @Override
    public void warn(String msg) {
        System.err.println(msg);
    }
}

class NullLog implements Log {
    @Override
    public void info(String msg) {
        //do nothing
    }

    @Override
    public void warn(String msg) {
        //do nothing
    }
}

class BankAccount {
    private int balance;
    private Log logger;

    public BankAccount(Log logger) {
        this.logger = logger;
        this.balance = 0;
    }

    public void deposit(int amount) {
        balance += amount;
        this.logger.info("Deposited amount : " + amount + ". New Balance : " + balance);
    }

    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            this.logger.info("Withdrew amount : " + amount+ ". New Balance : " + balance);
        } else {
            this.logger.warn("Cannot withdraw amount : " + amount + ". Insufficient Balance : " + balance);
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }
}



public class NullObject {
    public static void main(String[] args) {
        ConsoleLog consoleLog = new ConsoleLog();
        BankAccount ba = new BankAccount(consoleLog);
        ba.deposit(500);
        ba.withdraw(100);


        // now using null object

        NullLog nullLog = new NullLog();
        BankAccount ba2 = new BankAccount(nullLog);
        ba2.deposit(200);
        ba2.withdraw(100);
        System.out.println("It will not any info for Bank Account 2.");
        System.out.println(ba2);
    }
}
