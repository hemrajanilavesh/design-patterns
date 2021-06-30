package com.lavesh.design.patterns.behavioral.memento;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/15/18
 * Time: 9:43 PM
 * To change this template use File | Settings | File Templates.
 */




class Token
{
    public int value = 0;

    public Token(int value)
    {
        this.value = value;
    }
}

class Memento
{
    public List<Token> tokens = new ArrayList<>();
}

class TokenMachine
{
    public List<Token> tokens = new ArrayList<>();

    public Memento addToken(int value)
    {
        return  addToken(new Token(value));
    }

    public Memento addToken(Token token)
    {
        tokens.add(token);
        Memento m = new Memento();
        m.tokens = tokens.stream().map(t -> new Token(t.value)).collect(Collectors.toList());
        return m;
    }

    public void revert(Memento m)
    {
        this.tokens = m.tokens.stream().map(t -> new Token(t.value)).collect(Collectors.toList());
    }
}


public class TokenMachineDemo {
    public static void main(String[] args) {
        TokenMachine tm = new TokenMachine();
        System.out.println("Made a token with value 111 and kept a reference");
        Token token = new Token(111);
        System.out.println("Added this token to the list");
        tm.addToken(token);
        Memento m = tm.addToken(222);
        System.out.println("Changed this token's value to 333 :)");
        token.value = 333;
        tm.revert(m);

        System.out.println(tm.tokens.size());
        System.out.println(tm.tokens.get(0).value);

    }
}
