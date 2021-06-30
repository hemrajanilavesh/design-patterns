package com.lavesh.design.patterns.behavioral.null_object;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/16/18
 * Time: 10:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class DynamicNullObject {

    public static <T> T noOperation(Class<T> itf) {

        return (T) Proxy.newProxyInstance(
                itf.getClassLoader(),
                new Class<?>[]{itf},
                (proxy, method, args) ->
                        {
                            if (method.getReturnType().equals(Void.TYPE))
                                return null;
                            else
                                return method.getReturnType().getConstructor().newInstance();
                        });

    }


    public static void main(String[] args) {
        ConsoleLog consoleLog = new ConsoleLog();
        BankAccount ba = new BankAccount(consoleLog);
        ba.deposit(500);
        ba.withdraw(100);


        // now using dynamic null object

        Log nullLog = noOperation(Log.class);
        BankAccount ba2 = new BankAccount(nullLog);
        ba2.deposit(200);
        ba2.withdraw(100);
        System.out.println("It will not any info for Bank Account 2.");
        System.out.println(ba2);
    }
}
