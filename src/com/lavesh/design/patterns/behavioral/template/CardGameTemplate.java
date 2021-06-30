package com.lavesh.design.patterns.behavioral.template;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/16/18
 * Time: 8:04 PM
 * To change this template use File | Settings | File Templates.
 */

class Creature
{
    public int attack, health;

    public Creature(int attack, int health)
    {
        this.attack = attack;
        this.health = health;
    }
}

// this is the template
abstract class CardGame
{
    public Creature [] creatures;

    public CardGame(Creature[] creatures)
    {
        this.creatures = creatures;
    }

    // return s-1 if no clear winner (both alive or both dead)
    public int combat(int creature1, int creature2)
    {
        Creature first = creatures[creature1];
        Creature second = creatures[creature2];
        hit(first, second);
        hit(second, first);
        boolean firstAlive = first.health > 0;
        boolean secondAlive = second.health > 0;

        if (firstAlive == secondAlive) return -1;

        return firstAlive ? creature1 : creature2;
    }

    // attacker hits other creature
    protected abstract void hit(Creature attacker, Creature other);
}

//concrete implementation of the template
class TemporaryCardDamageGame extends CardGame
{
    public TemporaryCardDamageGame(Creature[] creatures) {
        super(creatures);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public int combat(int creature1, int creature2) {
        return super.combat(creature1, creature2);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected void hit(Creature attacker, Creature other) {
        int oldHealth = other.health;
        other.health -= attacker.attack;
        if (other.health > 0) {
            // then it is alive hence restore health
            other.health = oldHealth;
        }
    }
    // todo
}

//concrete implementation of the template
class PermanentCardDamageGame extends CardGame
{
    public PermanentCardDamageGame(Creature[] creatures) {
        super(creatures);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public int combat(int creature1, int creature2) {
        return super.combat(creature1, creature2);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected void hit(Creature attacker, Creature other) {
        other.health -= attacker.attack;
    }
    // todo
}

public class CardGameTemplate {
    public static void main(String[] args) {
        Creature c1 = new Creature(1, 2);
        Creature c2 = new Creature(1, 2);
        TemporaryCardDamageGame game = new TemporaryCardDamageGame(new Creature[]{c1, c2});
        //assertEquals(-1, game.combat(0,1));
        System.out.println(game.combat(0,1));
        //assertEquals(-1, game.combat(0,1));
        System.out.println(game.combat(0,1));

    }
}
