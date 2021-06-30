package com.lavesh.design.patterns.creational.prototype;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/11/18
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
class Foo implements Serializable
{
    public int stuff;
    public String whatever;

    public Foo(int stuff, String whatever)
    {
        this.stuff = stuff;
        this.whatever = whatever;
    }

    @Override
    public String toString()
    {
        return "Foo{" +
                "stuff=" + stuff +
                ", whatever='" + whatever + '\'' +
                '}';
    }
}


public class CopyThroughSerialization {

    public static void main(String[] args) {
        Foo foo = new Foo(5, "like");

    }
}
