package com.lavesh.design.patterns.behavioral.chain_of_responsibility;

import java.util.* ;
import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/15/18
 * Time: 1:22 PM
 * To change this template use File | Settings | File Templates.
 */

class Event<TArgs> {
    private int index = 0;
    private Map<Integer, Consumer<TArgs>> handlers = new HashMap<>();

    public int subscribe(Consumer<TArgs> handler) {
        int i = index;
        handlers.put(index++,handler);
        return i;
    }

    public void unsubscribe(int key) {
        handlers.remove(key);
    }

    public void fire(TArgs args) {
        for (Consumer<TArgs> handler: handlers.values()) {
            handler.accept(args);
        }
    }

}

class Query {
    enum Argument {
        ATTACK, DEFENSE
    }
    public String creatureName;
    public Argument argument;
    public int result;

    Query(String creatureName, Argument argument, int result) {
        this.creatureName = creatureName;
        this.argument = argument;
        this.result = result;
    }
}

class Game {
     public Event<Query> queries = new Event<>();
}

class Creature {
    private Game game;
    public String name;
    private int baseAttack, baseDefense;

    public Creature(Game game, String name, int baseAttack, int baseDefense) {
        this.game = game;
        this.name = name;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
    }

    int getAttack () {
        Query q = new Query(name, Query.Argument.ATTACK, baseAttack);
        game.queries.fire(q);
        return q.result;
    }

    int getDefense () {
        Query q = new Query(name, Query.Argument.DEFENSE, baseDefense);
        game.queries.fire(q);
        return q.result;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "game=" + game +
                ", name='" + name + '\'' +
                ", baseAttack=" + getAttack() +
                ", baseDefense=" + getDefense() +
                '}';
    }
}

class CreatureModifier {
    protected Game game;
    protected Creature creature;

    public CreatureModifier(Game game, Creature creature) {
        this.game = game;
        this.creature = creature;
    }
}

class DoubleAttackModifier extends CreatureModifier implements AutoCloseable{

    private int token;
    public DoubleAttackModifier(Game game, Creature creature) {
        super(game, creature);    //To change body of overridden methods use File | Settings | File Templates.
        token = game.queries.subscribe(q -> {
            if (q.creatureName.equals(creature.name) && q.argument == Query.Argument.ATTACK) {
                q.result *= 2;
            }
        });
    }

    @Override
    public void close() throws Exception {
        game.queries.unsubscribe(token);
    }
}

class IncreaseDefenseModifier extends CreatureModifier implements AutoCloseable{
    private int token;
    public IncreaseDefenseModifier(Game game, Creature creature) {
        super(game, creature);    //To change body of overridden methods use File | Settings | File Templates.
        token = game.queries.subscribe(q -> {
           if (q.argument == Query.Argument.DEFENSE && q.creatureName.equals(creature.name)) {
               q.result +=3;
           }
        });
    }

    @Override
    public void close() throws Exception {
        game.queries.unsubscribe(token);
    }
}




public class BrokerChain {
    public static void main(String[] args) {
        Game game = new Game();
        Creature goblin = new Creature(game,
                "Strong Goblin", 2, 2);

        System.out.println(goblin);

        // modifiers can be piled up
        IncreaseDefenseModifier icm = new IncreaseDefenseModifier(game, goblin);

        try (DoubleAttackModifier dam
                     = new DoubleAttackModifier(game, goblin))
        {
            System.out.println(goblin);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(goblin);
    }
}
