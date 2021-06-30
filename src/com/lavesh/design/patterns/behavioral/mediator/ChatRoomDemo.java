package com.lavesh.design.patterns.behavioral.mediator;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/16/18
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */

class Person {

    public String name;
    public ChatRoom room;
    private List<String> chatLog = new ArrayList<>();

    Person(String name) {
        this.name = name;
    }

    public void receive(String sender, String message) {
        String s = sender + ": '" + message + "'";
        System.out.println("[" + name + "'s chat session] " + s);
        chatLog.add(s);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void say(String message) {
         this.room.broadcast(name,message);
    }

    public void privateMessage(String toWho, String message) {
         room.message(name, toWho, message);
    }
}

/*this component is the mediator*/
class ChatRoom {

    private Set<Person> setOfPeople = new HashSet<>(5);

    public void broadcast(String sender, String message) {
          setOfPeople.stream().forEach(
                  person -> {
                      if (!person.equals(sender)) {
                           person.receive(sender, message);
                      }
                  }
          );
    }

    public void join(Person person) {
        String s = person.name + " has joined the chat";
        person.room = this;
        this.setOfPeople.add(person);
        broadcast("room", s);
    }

    public void message(String sender, String receiver, String message) {
        setOfPeople.stream()
                .filter(p -> p.name.equals(receiver))
                .findFirst()
                .ifPresent(p -> p.receive(sender, receiver));
    }

}


public class ChatRoomDemo {
    public static void main(String[] args) {
        ChatRoom room = new ChatRoom();

        Person john = new Person("John");
        Person jane = new Person("Jane");

        room.join(john); // no message here
        room.join(jane);

        john.say("hi room");
        jane.say("oh, hey john");

        Person simon = new Person("Simon");
        room.join(simon);
        simon.say("hi everyone!");

        jane.privateMessage("Simon", "glad you could join us!");

    }
}
