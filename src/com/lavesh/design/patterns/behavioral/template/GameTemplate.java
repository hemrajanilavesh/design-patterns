package com.lavesh.design.patterns.behavioral.template;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/16/18
 * Time: 7:49 PM
 * To change this template use File | Settings | File Templates.
 */

abstract class Game {
    protected int currentPlayer;
    protected final int numberOfPlayer;

    public Game(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    // skeleton algorithm i.e. the template
    public void run() {
        start();
        while (!haveWinner()) {
            takeTurn();
        }
        System.out.println("Player " + getWinningPlayer() + " wins!!!");
    }

    protected abstract boolean haveWinner();
    protected abstract int getWinningPlayer();
    protected abstract void takeTurn();
    protected abstract void start();

}

class Chess extends Game {

    private int maxTurns = 10;
    private int turn = 0;

    public Chess() {
        super(2);    // because chess always has 2 players
    }

    @Override
    public void run() {
        super.run();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected boolean haveWinner() {
        return turn == maxTurns;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected int getWinningPlayer() {
        return currentPlayer;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void takeTurn() {
        if (currentPlayer == 0) {
            currentPlayer = 1;
        } else if (currentPlayer == 1) {
            currentPlayer = 0;
        }
        System.out.println("Turn " + (turn++) + " taken by player " + currentPlayer);
    }

    @Override
    protected void start() {
        System.out.println("Starting a game of Chess");
    }
}


public class GameTemplate {
    public static void main(String[] args) {
        new Chess().run();
    }
}
