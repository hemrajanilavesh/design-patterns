package com.lavesh.design.patterns.structural.proxy.commands;

public class CommandExecutorDemo {
    public static void main(String[] args) {
        CommandExecutor standardUser = new CommandExecutorProxy(false);
        standardUser.runCommand();

        CommandExecutor adminUser = new CommandExecutorProxy(true);
        adminUser.runCommand();

    }
}
