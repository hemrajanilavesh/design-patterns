package com.lavesh.design.patterns.behavioral.iterator;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/15/18
 * Time: 8:05 PM
 * To change this template use File | Settings | File Templates.
 */

class Creature implements Iterable<Integer> {

    private static int [] stats = new int[3];

    public int getStrength() {
        return stats[0];
    }

    public void setStrength (int value) {
        stats[0] = value;
    }

    public int getAgility() {
        return stats[1];
    }

    public void setAgility (int value) {
        stats[1] = value;
    }

    public int getIntelligence() {
        return stats[2];
    }

    public void setIntelligence (int value) {
        stats[2] = value;
    }

    public int max() {
        return IntStream.of(stats).max().getAsInt();
    }

    public double average() {
        return IntStream.of(stats).average().getAsDouble();
    }

    public int sum() {
        return IntStream.of(stats).sum();
    }


    @Override
    public Iterator<Integer> iterator() {
        return IntStream.of(stats).iterator();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        for (int x: this) {
            action.accept(x);
        }
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return IntStream.of(stats).spliterator();  //To change body of implemented methods use File | Settings | File Templates.
    }
}


public class ArrayBackedProperty {
    public static void main(String[] args) {
        Creature creature = new Creature();
        creature.setAgility(12);
        creature.setIntelligence(13);
        creature.setStrength(17);
        System.out.println(
                "Creature has a max stat of " + creature.max()
                        + ", total stats of " + creature.sum()
                        + " and an average stat of " + creature.average()
        );
    }
}
