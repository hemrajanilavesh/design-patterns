package com.lavesh.design.patterns.behavioral.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/16/18
 * Time: 11:30 AM
 * To change this template use File | Settings | File Templates.
 */

class Event<TArgs> {
    private int count = 0;
    private Map<Integer, Consumer<TArgs>> handlers = new HashMap<>();

    public Subscription addHandler(Consumer<TArgs> handler) {
        int i = count;
        handlers.put(count++, handler);
        return new Subscription(this, i);
    }

    public void fire(TArgs args) {
        for (Consumer<TArgs> handler: handlers.values()) {
            handler.accept(args);
        }
    }

    /*this is a memnto*/
    class Subscription implements AutoCloseable{
        private Event<TArgs> event;
        private int id;

        Subscription(Event<TArgs> event, int id) {
            this.event = event;
            this.id = id;
        }

        @Override
        public void close() throws Exception {
            event.handlers.remove(id);
        }
    }
}

class Person2 {
    Event<PropertyChangedEventArgs> propertyChanged = new Event<>();

    private int age;

    int getAge() {
        return age;
    }

    void setAge(int age) {
        if (this.age == age) return;

        boolean oldCanVote = this.canVote();
        this.age = age;
        this.propertyChanged.fire(new PropertyChangedEventArgs(this,"age",age));

        if (oldCanVote != this.canVote()) {
            // this means person is now eligible for voting after this age change
            this.propertyChanged.fire(new PropertyChangedEventArgs(this,"canVote",true));
        }
    }

    public boolean canVote() {
        return this.age >= 18;
    }

}

public class EventBasedObserver {
    public static void main(String[] args) {
        Person2 person2 = new Person2();
        Event<PropertyChangedEventArgs>.Subscription sub = person2.propertyChanged.addHandler(
                x -> System.out.println("Person's " + x.propertyName + " has been changed to " + x.value)
        );
        for (int i = 15; i < 19; i++) {
            person2.setAge(i);
        }
        try {
            sub.close();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        person2.setAge(20);

    }
}
