package com.lavesh.design.patterns.structural.proxy.commands;

/**
 * Proxy pattern is used to create a proxy of actual object.
 * It is used when you don't want to give client program complete control of actual object.
 * Proxy object is used to do a check / validation before invoking action on actual object.
 */
public class CommandExecutorProxy implements CommandExecutor {

    private boolean isAdmin;
    private CommandExecutor commandExecutor;

    public CommandExecutorProxy(boolean isAdmin) {
        this.isAdmin = isAdmin;
        this.commandExecutor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand() {

        if (isAdmin) {
            commandExecutor.runCommand();
        } else {
            System.out.println("Cannot Run/Execute Command, requires ADMIN access. ");
        }
        
    }
}
