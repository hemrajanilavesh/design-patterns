package com.lavesh.design.patterns.structural.proxy.commands;

public class CommandExecutorImpl implements CommandExecutor {
    @Override
    public void runCommand() {
        System.out.println("Command executed successfully.");
    }
}
