package com.lavesh.design.patterns.behavioral.command;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/15/18
 * Time: 5:18 PM
 * To change this template use File | Settings | File Templates.
 */

class BankAccount {

    public int balance = 0;
    public int overdraftLimit = -500;

    public boolean deposit(int amount) {
        balance += amount;
        System.out.println("Depositing amount " + amount + " into bank account.");
        return true;
    }

    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawing amount " + amount + " from bank account.");
            return true;
        } else {
            System.out.println("Cannot Withdraw amount " + amount + " from bank account. Insufficient balance.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }
}

interface BankCommand {
    void call();
    void undo();
}

class BankAccountCommand implements BankCommand{

    enum Command {
        WITHDRAW, DEPOSIT
    }

    Command command;
    boolean commandStatus;
    int amount;
    BankAccount bankAccount;

    BankAccountCommand(Command command, int amount, BankAccount bankAccount) {
        this.command = command;
        this.amount = amount;
        this.bankAccount = bankAccount;
    }

    @Override
    public void call() {
        switch (command) {
            case WITHDRAW:
                commandStatus = bankAccount.withdraw(amount);
                break;
            case DEPOSIT:
                commandStatus = bankAccount.deposit(amount);
                break;
        }
    }

    @Override
    public void undo() {

        if(!commandStatus) {
            return; // if the original command didn't succeed then it should not be undone
        }

        switch (command) {
            case WITHDRAW:
                commandStatus = bankAccount.deposit(amount);
                break;
            case DEPOSIT:
                commandStatus = bankAccount.withdraw(amount);
                break;
        }
    }
}

public class BankAccountCommandDemo {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        List<BankAccountCommand> commands = new ArrayList<>();
        commands.add(new BankAccountCommand(BankAccountCommand.Command.DEPOSIT, 500, ba));
        commands.add(new BankAccountCommand(BankAccountCommand.Command.WITHDRAW, 200, ba));
        commands.add(new BankAccountCommand(BankAccountCommand.Command.WITHDRAW, 500, ba));
        System.out.println(ba);
        for(BankCommand command: commands) {
            command.call();
            System.out.println(ba);
        }
        // undo all the commands in reverse order
        Collections.reverse(commands);
        for(BankCommand command: commands) {
            command.undo();
            System.out.println(ba);
        }

    }
}
