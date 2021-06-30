package com.lavesh.design.patterns.behavioral.state;

/**
 * In State design pattern, the behaviour of the object changes based on the it's "state".
 */


interface TvState {
    void doAction();
}

/**
 * This is a state in which TV can be.
 */
class TvOnState implements TvState {
    @Override
    public void doAction() {
        System.out.println("TV is turned ON.");
    }
}

/**
 * This is a state in which TV can be.
 */
class TvOffState implements TvState {
    @Override
    public void doAction() {
        System.out.println("TV is turned OFF.");
    }
}

class TvStandByState implements TvState {
    @Override
    public void doAction() {
        System.out.println("TV is in STAND BY mode.");
    }
}

/**
 * Context which receives the state change request.
 * Provides lose coupling and extensibility.
 */

class TvContext implements TvState {

    private TvState tvState;

    public TvContext(TvState tvState) {
        this.tvState = tvState;
    }

    public TvState getTvState() {
        return tvState;
    }

    public void setTvState(TvState tvState) {
        this.tvState = tvState;
    }

    @Override
    public void doAction() {
        this.tvState.doAction();
    }
}


public class TVStateDemo {
    public static void main(String[] args) {
       TvContext tvContext = new TvContext(new TvOnState());
       tvContext.doAction();
       tvContext.setTvState(new TvStandByState());
       tvContext.doAction();
       tvContext.setTvState(new TvOffState());
       tvContext.doAction();
    }
}
