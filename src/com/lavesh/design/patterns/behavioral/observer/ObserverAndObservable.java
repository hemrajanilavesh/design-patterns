package com.lavesh.design.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/16/18
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */

class PropertyChangedEventArgs<T> {
    public T source;
    public String propertyName;
    public Object value;

    PropertyChangedEventArgs(T source, String propertyName, Object value) {
        this.source = source;
        this.propertyName = propertyName;
        this.value = value;
    }
}

interface Observer<T> {
    void handle(PropertyChangedEventArgs<T> args);
}

class Observable<T> {
     private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer<T> observer) {
        this.observers.add(observer);
    }

    protected void propertyChangedEvent(T source, String propertyName, Object value) {
        for (Observer o : observers) {
            o.handle(new PropertyChangedEventArgs(source,propertyName, value));
        }
    }

}

class Person extends Observable<Person> {
    private int age;

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
        propertyChangedEvent(this,"age",this.age);
    }
}

public class ObserverAndObservable implements Observer{

    public static void main(String[] args) {
         ObserverAndObservable observerAndObservable = new ObserverAndObservable();
    }

    public ObserverAndObservable() {
        Person person = new Person();
        person.subscribe(this);
        for (int i = 10; i < 15; i++) {
            person.setAge(i);
        }
    }

    @Override
    public void handle(PropertyChangedEventArgs args) {
        System.out.println("Person's " + args.propertyName + " has been changed to " + args.value);
    }
}
