package com.lavesh.design.patterns.behavioral.mediator;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/16/18
 * Time: 1:27 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.util.List;

class Participant
{
    private Mediator mediator;
    public int value;

    public Participant(Mediator mediator)
    {
        this.mediator = mediator;
        this.value = 0;
        this.mediator.subscribe(this);
    }

    public void say(int n)
    {
         mediator.broadcast(this, n);
    }
}

class Mediator
{
   List<Participant> participants = new ArrayList<>();

   public void subscribe(Participant p) {
       this.participants.add(p);
   }

    public void broadcast(Participant participant, int value) {
        participants.stream().forEach(
                p -> {
                    if (!p.equals(participant))
                        p.value += value;
                }
        );
    }

}

public class Exercise {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Participant p1 = new Participant(mediator);
        Participant p2 = new Participant(mediator);


        System.out.println(p1.value);
        System.out.println(p2.value);

        p1.say(2);

        System.out.println(p1.value);
        System.out.println(p2.value);

        p2.say(4);

        System.out.println(p1.value);
        System.out.println(p2.value);
    }
}
