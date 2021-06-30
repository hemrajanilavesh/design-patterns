package com.lavesh.design.patterns.behavioral.observer;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/16/18
 * Time: 12:05 PM
 * To change this template use File | Settings | File Templates.
 */

class Game
{
    List<Rat> ratsInPlay = new ArrayList<>();
}

class Rat implements Closeable
{
    private Game game;
    public int attack = 1;

    public Rat(Game game)
    {
        this.game = game;
        this.game.ratsInPlay.add(this);
        int ratCount =   this.game.ratsInPlay.size();
        this.game.ratsInPlay.stream().forEach(r -> {
            r.attack = ratCount;
        });
    }

    @Override
    public void close() throws IOException
    {
        this.game.ratsInPlay.stream().forEach(r -> r.attack--);
        game.ratsInPlay.remove(this);
    }
}

public class Exercise {
    public static void main(String[] args) {
        Game game = new Game();

        Rat rat = new Rat(game);
        System.out.println(rat.attack);

        Rat rat2 = new Rat(game);
        System.out.println(rat.attack);
        System.out.println(rat2.attack);
        try (Rat rat3 = new Rat(game))
        {
            //assertEquals(3, rat.attack);
            System.out.println(rat.attack);
           // assertEquals(3, rat2.attack);
            System.out.println(rat2.attack);
            //assertEquals(3, rat3.attack);
            System.out.println(rat3.attack);
        } catch (Exception ex) {
            System.err.println("Exception");
        }

        //assertEquals(2, rat.attack);
        System.out.println(rat.attack);
        //assertEquals(2, rat2.attack);
        System.out.println(rat2.attack);
    }
}

